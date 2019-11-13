package com.pret.api.service.impl;

import com.pret.api.vo.PageFormVo;
import com.pret.api.filter.BaseContext;
import com.pret.api.service.BaseManageService;
import com.pret.common.VersionedAuditableIdEntity;
import com.pret.common.constant.CommonConstants;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.repository.BaseRepository;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 基础service
 */
public abstract class BaseServiceImpl<M extends BaseRepository<T>, T extends VersionedAuditableIdEntity, D extends PageFormVo> implements BaseManageService<T, D> {
    @Autowired
    public M repository;
    @Autowired
    public BaseContext baseContext;

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public Iterable<T> save(Iterable<T> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public void delete(String id) {
        Optional<T> t = this.findById(id);
        repository.delete(t.get());
    }

    @Override
    public void deleteByIds(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            Optional<T> t = this.findById(id);
            t.get().setS(0);
            repository.save(t.get());
        }
    }

    @Override
    public void lDelete(String id) {
        Optional<T> t = this.findById(id);
        repository.save(t.get());
    }

    @Override
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Override
    public void delete(Iterable<T> entities) {
        repository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public Optional<T> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<T> findAll() {
        return repository.findAll();
    }

    @Override
    public List<T> findByS(String s) {
        return null;
    }

    @Override
    public Iterable<T> findAll(Iterable<String> ids) {
        return repository.findAllById(ids);
    }

    @Override
    public Iterable<T> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<T> page(final D vo) {
        Page<T> page = repository.findAll(new Specification<T>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();
                list.add(cb.equal(root.<Integer>get("s"), 1));
                Field[] fields = vo.getClass().getDeclaredFields();
                for (Field field : fields) {
                    if (field.getName().contains(CommonConstants.QUERY_MARKER)) {
                        String fileName = field.getName();

                        // 生成String类型参数
                        this.genString(vo, root, cb, list, field, fileName);

                        // 生成int or long类型
                        this.genIntOrLong(vo, root, cb, list, field, fileName);

                        // 生成list类型
                        this.genList(vo, root, cb, list, field, fileName);

                        // 生成Date类型
                        this.genDate(vo, root, cb, list, field, fileName);

                        // 生成Boolean
                        this.genBoolean(vo, root, cb, list, field, fileName);
                    }
                }

                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }

            /**
             *  通过反射获取in条件
             * @param vo
             * @param root
             * @param cb
             * @param list
             * @param field
             * @param fileName
             */
            private void genList(D vo, Root<T> root, CriteriaBuilder cb, List<Predicate> list, Field field,
                                 String fileName) {
                String type = field.getType().toString();
                System.out.print("=======================================type============================================:" + type);
                if (type.equals(ConstantEnum.QueryGenericType.List.getGenericType())) {
                    try {
                        ParameterizedType listGenericType = (ParameterizedType) field.getGenericType();
                        Type[] listActualTypeArguments = listGenericType.getActualTypeArguments();
                        String typeName = listActualTypeArguments[0].getTypeName();
                        String subFieldName = fileName.substring(fileName.indexOf(CommonConstants.QUERY_MARKER) + 1);
                        if (typeName.equals(ConstantEnum.QueryGenericType.ListString.getGenericType())) {
                            String[] fieldValue = BeanUtils.getArrayProperty(vo, fileName);
                            if (fieldValue != null && fieldValue.length > 0) {
                                List<String> idList = new ArrayList<>();
                                for (String v : fieldValue) {
                                    idList.add(v);
                                }
                                if (fieldValue != null && fieldValue.length > 0) {
                                    String pub = fileName.substring(0, fileName.indexOf(CommonConstants.QUERY_MARKER) + 1);
                                    if (pub.equals(ConstantEnum.QueryType.in$.name())) {
                                        list.add(cb.in(root.get(subFieldName)).value(idList));
                                    } else if (pub.equals(ConstantEnum.QueryType.lm$.name())) {
                                        Predicate[] ps = new Predicate[idList.size()];
                                        int i = 0;
                                        for (String propValue : idList) {
                                            if (!StringUtils.isEmpty(propValue)) {
                                                Predicate predicate = cb.like(root.<String>get(subFieldName), "%" + propValue + "%");
                                                ps[i] = predicate;
                                                i++;
                                            }
                                        }
                                        list.add(cb.or(ps));
                                    }
                                }
                            }
                        } else if (typeName.equals(ConstantEnum.QueryGenericType.Long.getGenericType())) {
                            String[] fieldValue = BeanUtils.getArrayProperty(vo, fileName);
                            if (fieldValue != null && fieldValue.length > 0) {
                                List<Long> idList = new ArrayList<>();
                                for (String v : fieldValue) {
                                    idList.add(Long.parseLong(v));
                                }
                                if (fieldValue != null && fieldValue.length > 0) {
                                    String pub = fileName.substring(0, fileName.indexOf(CommonConstants.QUERY_MARKER) + 1);
                                    if (pub.equals(ConstantEnum.QueryType.in$.name())) {
                                        list.add(cb.in(root.get(subFieldName)).value(idList));
                                    } else if (pub.equals(ConstantEnum.QueryType.lm$.name())) {
                                        Predicate[] ps = new Predicate[idList.size()];
                                        int i = 0;
                                        for (Long propValue : idList) {
                                            if (propValue > 0) {
                                                Predicate predicate = cb.equal(root.<String>get(subFieldName), propValue);
                                                ps[i] = predicate;
                                                i++;
                                            }
                                        }
                                        list.add(cb.or(ps));
                                    }
                                }
                            }
                        } else if (typeName.equals(ConstantEnum.QueryGenericType.Integer.getGenericType())) {
                            String[] fieldValue = BeanUtils.getArrayProperty(vo, fileName);
                            if (fieldValue != null && fieldValue.length > 0) {
                                List<Integer> idList = new ArrayList<>();
                                for (String v : fieldValue) {
                                    idList.add(Integer.parseInt(v));
                                }
                                if (fieldValue != null && fieldValue.length > 0) {
                                    String pub = fileName.substring(0, fileName.indexOf(CommonConstants.QUERY_MARKER) + 1);
                                    if (pub.equals(ConstantEnum.QueryType.in$.name())) {
                                        list.add(cb.in(root.get(subFieldName)).value(idList));
                                    } else if (pub.equals(ConstantEnum.QueryType.lm$.name())) {
                                        Predicate[] ps = new Predicate[idList.size()];
                                        int i = 0;
                                        for (Integer propValue : idList) {
                                            if (propValue > 0) {
                                                Predicate predicate = cb.equal(root.<String>get(subFieldName), propValue);
                                                ps[i] = predicate;
                                                i++;
                                            }
                                        }
                                        list.add(cb.or(ps));
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            /**
             * 生成日期
             *
             * @param vo
             * @param root
             * @param cb
             * @param list
             * @param field
             * @param fileName
             */
            private void genDate(D vo, Root<T> root, CriteriaBuilder cb, List<Predicate> list, Field field,
                                 String fileName) {
                if (field.getGenericType().toString().equals(ConstantEnum.QueryGenericType.Date.getGenericType())) {
                    try {
                        String pub = fileName.substring(0, fileName.indexOf(CommonConstants.QUERY_MARKER) + 1);
                        String fieldValueStr = BeanUtils.getProperty(vo, fileName);
                        if (!StringUtils.isEmpty(fieldValueStr) && pub.equals(ConstantEnum.QueryType.bw$.name())) {
                            String subFieldName = fileName.substring(fileName.indexOf(ConstantEnum.QueryType.bw$.name()) + 1);
                            Date start = DateUtils.parseDate(BeanUtils.getProperty(vo, fileName),
                                    "yyyy-MM-dd HH:mm:ss");
                            Date end = DateUtils.parseDate(
                                    BeanUtils.getProperty(vo, fileName + "End"),
                                    "yyyy-MM-dd HH:mm:ss");

                            list.add(cb.between(root.<Date>get(subFieldName), start, end));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            /**
             * 生成boolean条件查询
             * @param vo
             * @param root
             * @param cb
             * @param list
             * @param field
             * @param fileName
             */
            private void genBoolean(D vo, Root<T> root, CriteriaBuilder cb, List<Predicate> list, Field field,
                                    String fileName) {
                if (field.getGenericType().toString().equals(ConstantEnum.QueryGenericType.Boolean.getGenericType())) {
                    try {
                        String fieldValueStr = BeanUtils.getProperty(vo, fileName);
                        if (!StringUtils.isEmpty(fieldValueStr)) {
                            boolean fieldValue = Boolean.parseBoolean(fieldValueStr);

                            String subFieldName = fileName.substring(fileName.indexOf(CommonConstants.QUERY_MARKER) + 1);
                            String pub = fileName.substring(0, fileName.indexOf(CommonConstants.QUERY_MARKER) + 1);
                            if (pub.equals(ConstantEnum.QueryType.eq$.name())) {
                                list.add(cb.equal(root.<Boolean>get(subFieldName), fieldValue));
                            }

                            if (pub.equals(ConstantEnum.QueryType.neq$.name())) {
                                list.add(cb.notEqual(root.<Boolean>get(subFieldName), fieldValue));
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            /**
             * 生成
             *
             * @param vo
             * @param root
             * @param cb
             * @param list
             * @param field
             * @param fileName
             */
            private void genIntOrLong(final D vo, Root<T> root, CriteriaBuilder cb, List<Predicate> list,
                                      Field field, String fileName) {
                String subFieldName = fileName.substring(fileName.indexOf(CommonConstants.QUERY_MARKER) + 1);
                String pub = fileName.substring(0, fileName.indexOf(CommonConstants.QUERY_MARKER) + 1);
                if (field.getGenericType().toString().equals(ConstantEnum.QueryGenericType.Int.getGenericType())
                        || field.getGenericType().toString().equals(ConstantEnum.QueryGenericType.Long.getGenericType())) {
                    try {
                        boolean isInteger = field.getGenericType().toString()
                                .equals(ConstantEnum.QueryGenericType.Int.getGenericType());
                        boolean isFloat = field.getGenericType().toString()
                                .equals(ConstantEnum.QueryGenericType.Float.getGenericType());
                        String fieldValueStr = BeanUtils.getProperty(vo, fileName);
                        if (!StringUtils.isEmpty(fieldValueStr)) {
                            if (isInteger) {
                                int fieldValue = Integer.parseInt(fieldValueStr);
                                if (fieldValue < 0) {
                                    return;
                                }
                                if (pub.equals(ConstantEnum.QueryType.eq$.name())) {
                                    list.add(cb.equal(root.<Integer>get(subFieldName), fieldValue));
                                }

                                if (pub.equals(ConstantEnum.QueryType.neq$.name())) {
                                    list.add(cb.notEqual(root.<Integer>get(subFieldName), fieldValue));
                                }

                                if (pub.equals(ConstantEnum.QueryType.bw$.name())) {
                                    int start = Integer.parseInt(BeanUtils.getProperty(vo, fileName + "Start"));
                                    int end = Integer
                                            .parseInt(BeanUtils.getProperty(vo, fileName + "End"));
                                    list.add(cb.between(root.<Integer>get(subFieldName), start, end));
                                }

                                if (pub.equals(ConstantEnum.QueryType.gt$.name())) {
                                    list.add(cb.greaterThan(root.<Integer>get(subFieldName), fieldValue));
                                }

                                if (pub.equals(ConstantEnum.QueryType.gte$.name())) {
                                    list.add(cb.greaterThanOrEqualTo(root.<Integer>get(subFieldName), fieldValue));
                                }

                                if (pub.equals(ConstantEnum.QueryType.lt$.name())) {
                                    list.add(cb.lessThan(root.<Integer>get(subFieldName), fieldValue));
                                }

                                if (pub.equals(ConstantEnum.QueryType.lte$.name())) {
                                    list.add(cb.lessThanOrEqualTo(root.<Integer>get(subFieldName), fieldValue));
                                }
                            } else if (isFloat) {
                                float fieldValue = Float.parseFloat(fieldValueStr);
                                if (fieldValue < 0) {
                                    return;
                                }
                                if (pub.equals(ConstantEnum.QueryType.eq$.name())) {
                                    list.add(cb.equal(root.<Float>get(subFieldName), fieldValue));
                                }

                                if (pub.equals(ConstantEnum.QueryType.neq$.name())) {
                                    list.add(cb.notEqual(root.<Float>get(subFieldName), fieldValue));
                                }

                                if (pub.equals(ConstantEnum.QueryType.bw$.name())) {
                                    float start = Float.parseFloat(BeanUtils.getProperty(vo, fileName + "Start"));
                                    float end = Float
                                            .parseFloat(BeanUtils.getProperty(vo, fileName + "End"));
                                    list.add(cb.between(root.<Float>get(subFieldName), start, end));
                                }

                                if (pub.equals(ConstantEnum.QueryType.gt$.name())) {
                                    list.add(cb.greaterThan(root.<Float>get(subFieldName), fieldValue));
                                }

                                if (pub.equals(ConstantEnum.QueryType.gte$.name())) {
                                    list.add(cb.greaterThanOrEqualTo(root.<Float>get(subFieldName), fieldValue));
                                }

                                if (pub.equals(ConstantEnum.QueryType.lt$.name())) {
                                    list.add(cb.lessThan(root.<Float>get(subFieldName), fieldValue));
                                }

                                if (pub.equals(ConstantEnum.QueryType.lte$.name())) {
                                    list.add(cb.lessThanOrEqualTo(root.<Float>get(subFieldName), fieldValue));
                                }
                            } else {
                                long fieldValue = Long.parseLong(fieldValueStr);
                                if (fieldValue <= 0) {
                                    return;
                                }
                                if (pub.equals(ConstantEnum.QueryType.eq$.name())) {
                                    list.add(cb.equal(root.<Long>get(subFieldName), fieldValue));
                                }

                                if (pub.equals(ConstantEnum.QueryType.neq$.name())) {
                                    list.add(cb.notEqual(root.<Long>get(subFieldName), fieldValue));
                                }

                                if (pub.equals(ConstantEnum.QueryType.bw$.name())) {
                                    long start = Long.parseLong(BeanUtils.getProperty(vo, fileName));
                                    long end = Long
                                            .parseLong(BeanUtils.getProperty(vo, subFieldName + "End"));
                                    list.add(cb.between(root.<Long>get(subFieldName), start, end));
                                }

                                if (pub.equals(ConstantEnum.QueryType.gt$.name())) {
                                    list.add(cb.greaterThan(root.<Long>get(subFieldName), fieldValue));
                                }

                                if (pub.equals(ConstantEnum.QueryType.gte$.name())) {
                                    list.add(cb.greaterThanOrEqualTo(root.<Long>get(subFieldName), fieldValue));
                                }

                                if (pub.equals(ConstantEnum.QueryType.lt$.name())) {
                                    list.add(cb.lessThan(root.<Long>get(subFieldName), fieldValue));
                                }

                                if (pub.equals(ConstantEnum.QueryType.lte$.name())) {
                                    list.add(cb.lessThanOrEqualTo(root.<Long>get(subFieldName), fieldValue));
                                }
                            }

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            /**
             * 生成String类型参数
             *
             * @param vo
             * @param root
             * @param cb
             * @param list
             * @param field
             * @param fileName
             */
            private void genString(final D vo, Root<T> root, CriteriaBuilder cb, List<Predicate> list,
                                   Field field, String fileName) {
                if (field.getGenericType().toString().equals(ConstantEnum.QueryGenericType.String.getGenericType())) {
                    try {
                        String fieldValue = BeanUtils.getProperty(vo, fileName);
                        String subFieldName = fileName.substring(fileName.indexOf(CommonConstants.QUERY_MARKER) + 1);
                        String pub = fileName.substring(0, fileName.indexOf(CommonConstants.QUERY_MARKER) + 1);
                        if (!StringUtils.isEmpty(fieldValue)) {
                            if (pub.equals(ConstantEnum.QueryType.eq$.name())) {
                                list.add(cb.equal(root.<String>get(subFieldName), fieldValue));
                            }

                            if (pub.equals(ConstantEnum.QueryType.neq$.name())) {
                                list.add(cb.notEqual(root.<String>get(subFieldName), fieldValue));
                            }

                            if (pub.equals(ConstantEnum.QueryType.l$.name())) {
                                list.add(cb.like(root.<String>get(subFieldName), "%" + fieldValue + "%"));
                            }

                            if (pub.equals(ConstantEnum.QueryType.nl$.name())) {
                                list.add(cb.notLike(root.<String>get(subFieldName), "%" + fieldValue + "%"));
                            }

                            if (pub.equals(ConstantEnum.QueryType.ll$.name())) {
                                String[] propArr = fileName.split("ll\\$");
                                List<String> props = new ArrayList<>();
                                for (String prop : propArr) {
                                    if (!StringUtils.isEmpty(prop)) {
                                        props.add(prop);
                                    }
                                }

                                Predicate[] ps = new Predicate[props.size()];
                                int i = 0;
                                for (String prop : props) {
                                    if (!StringUtils.isEmpty(prop)) {
                                        Predicate predicate = cb.like(root.<String>get(prop), "%" + fieldValue + "%");
                                        ps[i] = predicate;
                                        i++;
                                    }
                                }
                                list.add(cb.or(ps));
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, vo);

        return page;
    }
}