package com.zhezhuo.model.entity;

import java.io.Serializable;

/**
 * Created by 蝈蝈 on 2016/9/19.
 */
public class UsersDO implements Serializable {

    private static final long serialVersionUID = 5582185928385916230L;
    private int userId;
    private String email;
    private String uname;
    private String unick;
    private int sex;
    private String password;
    private String avatar;
    private int registertype;
    private String registerip;
    private String registertime;
    private String lastloginip;
    private String lastlogintime;
    private int isDeleted;
    private int noLogin;
    private int status;
    private int cmessage;
    private int ctopic;
    private int calbum;
    private int cfollowtopic;
    private int cfollow;
    private int cfans;
    private int cfavs;
    private int cfaved;
    private int catme;
    private int creply;
    private int cmsg;
    private int sendMsg;
    private int csysmsg;
    private String updated;
    private int subsite;
    private String ID;
    private String trueName;
    private String invitcode;
    private Integer parentId;
    private String clientId;
    private String username;
    private String device;
    private int member;

    public int getMember() {
		return member;
	}

	public void setMember(int member) {
		this.member = member;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private String inviter;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUnick() {
        return unick;
    }

    public void setUnick(String unick) {
        this.unick = unick;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getRegistertype() {
        return registertype;
    }

    public void setRegistertype(int registertype) {
        this.registertype = registertype;
    }

    public String getRegisterip() {
        return registerip;
    }

    public void setRegisterip(String registerip) {
        this.registerip = registerip;
    }

    public String getLastloginip() {
        return lastloginip;
    }

    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getNoLogin() {
        return noLogin;
    }

    public void setNoLogin(int noLogin) {
        this.noLogin = noLogin;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCmessage() {
        return cmessage;
    }

    public void setCmessage(int cmessage) {
        this.cmessage = cmessage;
    }

    public int getCtopic() {
        return ctopic;
    }

    public void setCtopic(int ctopic) {
        this.ctopic = ctopic;
    }

    public int getCalbum() {
        return calbum;
    }

    public void setCalbum(int calbum) {
        this.calbum = calbum;
    }

    public int getCfollowtopic() {
        return cfollowtopic;
    }

    public void setCfollowtopic(int cfollowtopic) {
        this.cfollowtopic = cfollowtopic;
    }

    public int getCfollow() {
        return cfollow;
    }

    public void setCfollow(int cfollow) {
        this.cfollow = cfollow;
    }

    public int getCfans() {
        return cfans;
    }

    public void setCfans(int cfans) {
        this.cfans = cfans;
    }

    public int getCfavs() {
        return cfavs;
    }

    public void setCfavs(int cfavs) {
        this.cfavs = cfavs;
    }

    public int getCfaved() {
        return cfaved;
    }

    public void setCfaved(int cfaved) {
        this.cfaved = cfaved;
    }

    public int getCatme() {
        return catme;
    }

    public void setCatme(int catme) {
        this.catme = catme;
    }

    public int getCreply() {
        return creply;
    }

    public void setCreply(int creply) {
        this.creply = creply;
    }

    public int getCmsg() {
        return cmsg;
    }

    public void setCmsg(int cmsg) {
        this.cmsg = cmsg;
    }

    public int getSendMsg() {
        return sendMsg;
    }

    public void setSendMsg(int sendMsg) {
        this.sendMsg = sendMsg;
    }

    public int getCsysmsg() {
        return csysmsg;
    }

    public void setCsysmsg(int csysmsg) {
        this.csysmsg = csysmsg;
    }

    public int getSubsite() {
        return subsite;
    }

    public void setSubsite(int subsite) {
        this.subsite = subsite;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getInvitcode() {
        return invitcode;
    }

    public void setInvitcode(String invitcode) {
        this.invitcode = invitcode;
    }

    public Integer getParentId() {
        if (parentId == null) {
            return 0;
        }
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getRegistertime() {
        return registertime;
    }

    public void setRegistertime(String registertime) {
        this.registertime = registertime;
    }

    public String getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(String lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getInviter() {
        return inviter;
    }

    public void setInviter(String inviter) {
        this.inviter = inviter;
    }

    @Override
    public String toString() {
        return "UsersDO{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", uname='" + uname + '\'' +
                ", unick='" + unick + '\'' +
                ", sex=" + sex +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", registertype=" + registertype +
                ", registerip='" + registerip + '\'' +
                ", registertime=" + registertime +
                ", lastloginip='" + lastloginip + '\'' +
                ", lastlogintime=" + lastlogintime +
                ", isDeleted=" + isDeleted +
                ", noLogin=" + noLogin +
                ", status=" + status +
                ", cmessage=" + cmessage +
                ", ctopic=" + ctopic +
                ", calbum=" + calbum +
                ", cfollowtopic=" + cfollowtopic +
                ", cfollow=" + cfollow +
                ", cfans=" + cfans +
                ", cfavs=" + cfavs +
                ", cfaved=" + cfaved +
                ", catme=" + catme +
                ", creply=" + creply +
                ", cmsg=" + cmsg +
                ", sendMsg=" + sendMsg +
                ", csysmsg=" + csysmsg +
                ", updated=" + updated +
                ", subsite=" + subsite +
                ", ID='" + ID + '\'' +
                ", trueName='" + trueName + '\'' +
                ", invitcode='" + invitcode + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
