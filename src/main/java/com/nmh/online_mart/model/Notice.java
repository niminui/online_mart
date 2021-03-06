package com.nmh.online_mart.model;

public class Notice {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.id
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.administrator_id
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    private Long administratorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.gmt_create
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.gmt_modified
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    private Long gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.details
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    private String details;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.id
     *
     * @return the value of notice.id
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.id
     *
     * @param id the value for notice.id
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.administrator_id
     *
     * @return the value of notice.administrator_id
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    public Long getAdministratorId() {
        return administratorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.administrator_id
     *
     * @param administratorId the value for notice.administrator_id
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    public void setAdministratorId(Long administratorId) {
        this.administratorId = administratorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.gmt_create
     *
     * @return the value of notice.gmt_create
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.gmt_create
     *
     * @param gmtCreate the value for notice.gmt_create
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.gmt_modified
     *
     * @return the value of notice.gmt_modified
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.gmt_modified
     *
     * @param gmtModified the value for notice.gmt_modified
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.details
     *
     * @return the value of notice.details
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    public String getDetails() {
        return details;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.details
     *
     * @param details the value for notice.details
     *
     * @mbg.generated Mon May 11 10:56:56 CST 2020
     */
    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }
}