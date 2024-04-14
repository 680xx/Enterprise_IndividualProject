package com.example.enterprise_individualproject.controllers;

import com.example.enterprise_individualproject.entities.Member;
import com.example.enterprise_individualproject.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    // Get all members
    @GetMapping("/admin/members")
    @ResponseBody
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    // Get member by id
    @GetMapping("/admin/member/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable int id) {
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    // Add a member
    @PostMapping("/admin/addmember")
    @ResponseBody
    public ResponseEntity<Member> addNewMember(@RequestBody Member member) {
       return new ResponseEntity<>(memberService.addNewMember(member), HttpStatus.CREATED);
    }

    // Delete a member
    @DeleteMapping("/admin/deletemember/{id}")
    public ResponseEntity<String> deleteMemberById(@PathVariable int id) {
    memberService.deleteMemberById(id);
       return ResponseEntity.ok("The member with id " + id + " was deleted");
    }

    // Delete a member (Thymeleaf)
    // Körde jag med samma delete-funktion i både Postman och Thymeleaf fick jag fel returer, t.ex. HTML-dokument i Postman.
    @RequestMapping(value = "/admin/deletemember2/{id}", method = RequestMethod.GET)
    public String deleteMemberById(@PathVariable("id") int id, Model model){
        memberService.deleteMemberById(id);
        model.addAttribute("members", memberService.getAllMembers());
        return "/member-page";
    }

    // Update a member
    @PutMapping("/admin/updatemember/{id}")
    @ResponseBody
    public ResponseEntity<Member> updateMember(@PathVariable int id, @RequestBody Member member) {
        return ResponseEntity.ok(memberService.updateMember(id, member));
    }

    // Thymeleaf
    @GetMapping(value ="/admin/deletemember")
    public String getAllMembers (Model model) {
        model.addAttribute("members", memberService.getAllMembers());
        return "/member-page";
    }

}