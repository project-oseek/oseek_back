package com.foodfinder.oseek.repository;

import com.foodfinder.oseek.domain.notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
