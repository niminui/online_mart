package com.nmh.online_mart.model;

public class Administrator {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column administrator.id
     *
     * @mbg.generated Fri Apr 24 22:09:38 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column administrator.name
     *
     * @mbg.generated Fri Apr 24 22:09:38 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column administrator.password
     *
     * @mbg.generated Fri Apr 24 22:09:38 CST 2020
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column administrator.avatar_url
     *
     * @mbg.generated Fri Apr 24 22:09:38 CST 2020
     */
    private String avatarUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column administrator.gmt_create
     *
     * @mbg.generated Fri Apr 24 22:09:38 CST 2020
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column administrator.gmt_modified
     *
     * @mbg.generated Fri Apr 24 22:09:38 CST 2020
     */
    private Long gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column administrator.a_token
     *
     * @mbg.generated Fri Apr 24 22:09:38 CST 2020
     */
    private String aToken;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column administrator.id
     *
     * @return the value of administrator.id
     *
     * @mbg.generated Fri Apr 24 22:09:38 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column administrator.id
     *
     * @param id the value for administrator.id
     *
     * @mbg.generated Fri Apr 24 22:09:38 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column administrator.name
     *
     * @return the value of administrator.name
     *
     * @mbg.generated Fri Apr 24 22:09:38 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column administrator.name
     *
     * @param name the value for administrator.name
     *
     * @mbg.generated Fri Apr 24 22:09:38 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column administrator.password
     *
     * @return the value of administrator.password
     *
     * @mbg.generated Fri Apr 24 22:09:38 CST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column administrator.password
     *
     * @param password the value for administrator.password
     *
     * @mbg.generated Fri Apr 24 22:09:38 CST 2020
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column administrator.avatar_url
     *
     * @return the value of administrator.avatar_url
     *
     * @mbg.generated Fri Apr 24 22:09:38 CST 2020
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column administrator.avatar_url
     *
     * @param avatarUrl the value for administrator.avatar_url
     *
     * @mbg.generated Fri Apr 24 22:09:38 CST 2020
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column administrator.gmt_create
     *
     * @return the value of administrator.gmt_create
     *
     * @mbg.generated Fri Apr 24 22:09:38 CST 2020
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column administrator.gmt_create
     *
     * @param gmtCreate the value for administrator.gmt_create
     *
     * @mbg.generated Fri Apr 24 22:09:38 CST 2020
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column administrator.gmt_modified
     *
     * @return the value of administrator.gmt_modified
     *
     * @mbg.generated Fri Apr 24 22:09:38 CST 2020
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column administrator.gmt_modified
     *
     * @param gmtModified the value for administrator.gmt_modified
     *
     * @mbg.generated Fri Apr 24 22:09:38 CST 2020
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column administrator.a_token
     *
     * @return the value of administrator.a_token
     *
     * @mbg.generated Fri Apr 24 22:09:38 CST 2020
     */
    public String getaToken() {
        return aToken;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column administrator.a_token
     *
     * @param aToken the value for administrator.a_token
     *
     * @mbg.generated Fri Apr 24 22:09:38 CST 2020
     */
    public void setaToken(String aToken) {
        this.aToken = aToken == null ? null : aToken.trim();
    }
}