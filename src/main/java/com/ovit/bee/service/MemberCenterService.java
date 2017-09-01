package com.ovit.bee.service;

public interface MemberCenterService {

	Integer findMyMessage(String account) throws Exception;

	Integer insertSignIn(String account);

    Integer findCountSignIn(String account);
}
