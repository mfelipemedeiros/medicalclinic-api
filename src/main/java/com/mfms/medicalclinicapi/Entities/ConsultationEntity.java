package com.mfms.medicalclinicapi.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="Consultations")
@Table(name="Consultations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConsultationEntity {

    @Id
    @GeneratedValue
    private long id;

    private String pacientName;

    private String doctorName;

    private String ConsultationDsc;


}
