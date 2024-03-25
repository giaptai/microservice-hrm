package com.hrm.hoso_chitiet.dto;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@MappedSuperclass //class cha không phải là entity
public class DateTimeObject {
    @Column(columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime create_at;

    @Column(columnDefinition = "DATETIME ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime update_at;

    @Column(columnDefinition = "boolean default 1")
    private boolean trangThai;

    public DateTimeObject(LocalDateTime create_at, LocalDateTime update_at) {
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public DateTimeObject() {
        this.create_at = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
        this.trangThai = true;
    }


    public void setUpdate_at() {
        this.update_at = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
    }
}
