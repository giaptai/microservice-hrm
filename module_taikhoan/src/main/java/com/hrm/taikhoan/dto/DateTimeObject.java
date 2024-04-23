package com.hrm.taikhoan.dto;

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
    private LocalDateTime createAt;

    @Column(columnDefinition = "DATETIME ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updateAt;

    @Column(columnDefinition = "boolean default 1")
    private boolean trangThai;

    public DateTimeObject(LocalDateTime createAt, LocalDateTime updateAt) {
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public DateTimeObject() {
        this.createAt = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
        this.trangThai = true;
    }


    public void setUpdateAt() {
        this.updateAt = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
    }
}
