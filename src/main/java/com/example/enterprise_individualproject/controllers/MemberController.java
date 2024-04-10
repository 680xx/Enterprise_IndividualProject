package com.example.enterprise_individualproject.controllers;

import com.example.enterprise_individualproject.entities.Member;
import com.example.enterprise_individualproject.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/admin/members")
    @ResponseBody
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @GetMapping("/admin/member/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable int id) {
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    @PostMapping("/admin/addmember")
    @ResponseBody
    public ResponseEntity<Member> addNewMember(@RequestBody Member member) {
       return new ResponseEntity<>(memberService.addNewMember(member), HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/deletemember/{id}")
    public ResponseEntity<String> deleteMemberById(@PathVariable int id) {
    memberService.deleteMemberById(id);
       return ResponseEntity.ok("Member with id " + id + " was deleted!");
    }

    @PutMapping("/admin/updatemember/{id}")
    @ResponseBody
    public ResponseEntity<Member> updateMember(@PathVariable int id, @RequestBody Member member) {
        return ResponseEntity.ok(memberService.updateMember(id, member));
    }


}