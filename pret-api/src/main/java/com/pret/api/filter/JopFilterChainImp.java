package com.pret.api.filter;

import com.pret.api.filter.impl.*;
import com.pret.api.session.ClothingSession;
import com.pret.api.vo.ReqBody;
import com.pret.api.filter.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * 过滤器链实现
 *
 * @author wujinsong
 */
@Service
public class JopFilterChainImp implements JopFilterChain {

    /*	private List<JopFilter> filters = new ArrayList<JopFilter>();*/
    private List<JopFilter> filters = new ArrayList<JopFilter>();
    @Autowired
    private AccessFormatFilter accessFormatFilter;
    @Autowired
    private AccessReturnTypeFilter accessReturnTypeFilter;
    @Autowired
    private AccessTypeFilter accessTypeFilter;
    @Autowired
    private RequestBodyJsr303Filter requestBodyJsr303Filter;
    @Autowired
    private TimestampFilter timestampFilter;
    @Autowired
    private SignFilter signFilter;

    @Override
    public ReqBody doFilter(ReqBody requestBody, HttpServletRequest httpServletRequest) {
        if (filters.size() < 1) {
            this.filters.add(accessFormatFilter);
            this.filters.add(accessReturnTypeFilter);
            this.filters.add(accessTypeFilter);
            this.filters.add(requestBodyJsr303Filter);
            this.filters.add(timestampFilter);
            this.filters.add(signFilter);
        }

        return new VirtualFilterChain(filters).doFilter(requestBody, httpServletRequest);
    }

    /**
     * @author sm
     * @description: 虚拟过滤器链，实现真正的链式过滤.
     */
    private static class VirtualFilterChain implements JopFilterChain {

        private List<? extends JopFilter> filters = new ArrayList<JopFilter>();

        private int currentPosition = 0;

        private ReqBody newRequestBody;

        private VirtualFilterChain(List<? extends JopFilter> additionalFilters) {
            this.filters = additionalFilters;
        }

        @Override
        public ReqBody doFilter(ReqBody requestBody, HttpServletRequest httpServletRequest) {
            if (currentPosition != filters.size()) {
                currentPosition++;
                JopFilter lastFilter = filters.get(currentPosition - 1);
                if (lastFilter instanceof AccessFormatFilter) {
                    lastFilter.doFilter(requestBody, httpServletRequest, this);
                    requestBody = newRequestBody = (ReqBody) ClothingSession.get("requestBody");
                    ClothingSession.clear();
                }
                if (currentPosition < filters.size()) {
                    JopFilter nextFilter = filters.get(currentPosition);
                    nextFilter.doFilter(requestBody, httpServletRequest, this);
                }

            }

            return newRequestBody;
        }
    }
}
