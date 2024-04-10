package com.example.enterprise_individualproject.repositories;

import com.example.enterprise_individualproject.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository <Member, Integer> {
}
