package br.abastraction.startabstraction.api.exemplo.entity;

import common.support.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exemple_entity")
public class ExempleEntity implements BaseEntity<Integer> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "desc_exemple", nullable = false, length = 100)
  private String descExemple;

  @Override
  public Integer getId() {
    return id;
  }
}
