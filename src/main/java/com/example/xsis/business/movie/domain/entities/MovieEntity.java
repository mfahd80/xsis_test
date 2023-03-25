package com.example.xsis.business.movie.domain.entities;

import com.example.xsis.business.shared_domain.base.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "movie", schema = "public")
public class MovieEntity extends BaseEntity {

    private String title;

    private String description;

    private Float rating;

    private String image;
}
