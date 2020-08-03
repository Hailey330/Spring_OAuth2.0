package com.cos.securityex01.config.auth.oauth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

	// userRequest는 code를 받아서 accessToken을 응답 받은 객체
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User oAuth2User = super.loadUser(userRequest); // google의 회원 프로필 조회
		// oAuth2User 정보를 어디에 담아서 무엇을 리턴하면 될까
		// 1. PrincipalDetails 에 OAuth2User 정보를 넣어준다.
		// 2. PrincipalDetails 를 리턴한다.
		// 기존의 로그인 + OAuth 로그인 => 세션 하나로 관리할 수 있음!
		System.out.println("oAuth2User : " + oAuth2User); // Token을 통해 응답 받은 회원정보
		System.out.println("userRequest tokenValue: " + userRequest.getAccessToken().getTokenValue());
		System.out.println("userRequest clientRegistration: " + userRequest.getClientRegistration());
		try {

		} catch (Exception e) {

		}
		return super.loadUser(userRequest); // 세션에 등록되는 것

	}

	private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {
		// 일반적으로 로그인할 때 유저 정보는 User Object가 들고 있음
		// OAuth2로 로그인할 때 유저 정보는 attributes ← 구성할 것!
		// DB에 해당하는 유저가 있는지 확인함
		// 있으면? → 유저 정보 update

		// 없으면? → 회원 가입 insert
		// return PrincipalDetails(); - Map 안에 attributes
		return null;
	}
}
