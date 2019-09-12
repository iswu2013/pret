package com.pret.common.senstive;

public class PositionNode {

    /**
     * 开始位置
     */
    private int startPosition;

    /**
     * 结束位置
     */
    private int endPosition;

    /**
     * @param startPosition
     * @param endPosition
     */
    public PositionNode(int startPosition, int endPosition) {
        super();
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    /**
     * @return the startPosition
     */
    public int getStartPosition() {
        return startPosition;
    }

    /**
     * @param startPosition the startPosition to set
     */
    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    /**
     * @return the endPosition
     */
    public int getEndPosition() {
        return endPosition;
    }

    /**
     * @param endPosition the endPosition to set
     */
    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PositionNode [startPosition=" + startPosition + ", endPosition=" + endPosition
                + "]";
    }
}
