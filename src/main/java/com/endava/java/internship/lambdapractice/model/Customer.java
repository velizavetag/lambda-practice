package com.endava.java.internship.lambdapractice.model;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static java.util.Optional.ofNullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	private MemberCard memberCard;
	public Optional<MemberCard> getMemberCard() {
		return ofNullable(memberCard);
	}
}
