package com.example.enterprise_individualproject.services;

import com.example.enterprise_individualproject.entities.Member;
import java.util.List;

public interface MemberServiceInterface {

    List<Member> getAllMembers();
    Member getMemberById(int id);
    Member addNewMember(Member member);
    Member updateMember(int id, Member member);
    void deleteMemberById(int id);

}