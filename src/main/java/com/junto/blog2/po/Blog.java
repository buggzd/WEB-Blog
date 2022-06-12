package com.junto.blog2.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "t_blog")
@Table
public class Blog {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private String coverPicture;
    private String flag;

    private Integer viewTimes;
    private boolean enableCopyright;
    private boolean enableSupport;
    private boolean enableComment;
    private boolean published;
    private boolean recommend;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creatTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @ManyToOne
    private Type type;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags=new ArrayList<>();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog")
    private List<Comment>comments=new ArrayList<>();

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Blog() {

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getCoverPicture() {
        return coverPicture;
    }

    public String getFlag() {
        return flag;
    }

    public Integer getViewTimes() {
        return viewTimes;
    }

    public boolean isEnableCopyright() {
        return enableCopyright;
    }

    public boolean isEnableSupport() {
        return enableSupport;
    }

    public boolean isEnableComment() {
        return enableComment;
    }

    public boolean isPublished() {
        return published;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCoverPicture(String coverPicture) {
        this.coverPicture = coverPicture;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setViewTimes(Integer viewTimes) {
        this.viewTimes = viewTimes;
    }

    public void setEnableCopyright(boolean enableCopyright) {
        this.enableCopyright = enableCopyright;
    }

    public void setEnableSupport(boolean enableSupport) {
        this.enableSupport = enableSupport;
    }

    public void setEnableComment(boolean enableComment) {
        this.enableComment = enableComment;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", coverPicture='" + coverPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", viewTimes=" + viewTimes +
                ", enableCopyright=" + enableCopyright +
                ", enableSupport=" + enableSupport +
                ", enableComment=" + enableComment +
                ", published=" + published +
                ", recommend=" + recommend +
                ", creatTime=" + creatTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
