package com.liult.com.myframework.moudle;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhilian-2 on 2016/1/13.
 */
public class AppConfig implements Serializable{

    private String agreement_url;
    private String bonus_url;
    private String member_intro_url;
    private String static_domain;
    private String recharge_url;
    private String credit_mall_url;
    private String invitation_url;
    private String buying_group_places_url;
    private String service_terms_url;
    private String customer_service_tel;
    private String pixer;
    private String img_url_format;
    private boolean should_show_map;
    private List<String> cookie_domains;

    public void setAgreement_url(String agreement_url) {
        this.agreement_url = agreement_url;
    }

    public void setBonus_url(String bonus_url) {
        this.bonus_url = bonus_url;
    }

    public void setMember_intro_url(String member_intro_url) {
        this.member_intro_url = member_intro_url;
    }

    public void setStatic_domain(String static_domain) {
        this.static_domain = static_domain;
    }

    public void setRecharge_url(String recharge_url) {
        this.recharge_url = recharge_url;
    }

    public void setCredit_mall_url(String credit_mall_url) {
        this.credit_mall_url = credit_mall_url;
    }

    public void setInvitation_url(String invitation_url) {
        this.invitation_url = invitation_url;
    }

    public void setBuying_group_places_url(String buying_group_places_url) {
        this.buying_group_places_url = buying_group_places_url;
    }

    public void setService_terms_url(String service_terms_url) {
        this.service_terms_url = service_terms_url;
    }

    public void setCustomer_service_tel(String customer_service_tel) {
        this.customer_service_tel = customer_service_tel;
    }

    public void setPixer(String pixer) {
        this.pixer = pixer;
    }

    public void setImg_url_format(String img_url_format) {
        this.img_url_format = img_url_format;
    }

    public void setShould_show_map(boolean should_show_map) {
        this.should_show_map = should_show_map;
    }

    public void setCookie_domains(List<String> cookie_domains) {
        this.cookie_domains = cookie_domains;
    }

    public String getAgreement_url() {
        return agreement_url;
    }

    public String getBonus_url() {
        return bonus_url;
    }

    public String getMember_intro_url() {
        return member_intro_url;
    }

    public String getStatic_domain() {
        return static_domain;
    }

    public String getRecharge_url() {
        return recharge_url;
    }

    public String getCredit_mall_url() {
        return credit_mall_url;
    }

    public String getInvitation_url() {
        return invitation_url;
    }

    public String getBuying_group_places_url() {
        return buying_group_places_url;
    }

    public String getService_terms_url() {
        return service_terms_url;
    }

    public String getCustomer_service_tel() {
        return customer_service_tel;
    }

    public String getPixer() {
        return pixer;
    }

    public String getImg_url_format() {
        return img_url_format;
    }

    public boolean isShould_show_map() {
        return should_show_map;
    }

    public List<String> getCookie_domains() {
        return cookie_domains;
    }
}
