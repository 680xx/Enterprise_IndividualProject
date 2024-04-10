package com.example.enterprise_individualproject.services;

import com.example.enterprise_individualproject.entities.Member;
import com.example.enterprise_individualproject.exceptions.ResourceNotFoundException;
import com.example.enterprise_individualproject.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService implements MemberServiceInterface {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(int id) {
        return memberRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Member", "Id", id));
    }

    @Override
    public Member addNewMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(int id, Member member) {
        memberRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Member", "Id", id));
        return memberRepository.save(member);
    }

    @Override
    public void deleteMemberById(int id) {
        memberRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Member", "Id", id));
        memberRepository.deleteById(id);
    }
}
