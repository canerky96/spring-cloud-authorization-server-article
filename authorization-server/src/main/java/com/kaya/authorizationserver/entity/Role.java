package com.kaya.authorizationserver.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity {

  private String name;
  private String code;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "permission_role",
      joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")})
  private List<Permission> permissions;
}
