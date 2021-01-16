package com.kaya.authorizationserver.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = true)
public class Permission extends BaseEntity {
  private String name;
  private String code;
}
