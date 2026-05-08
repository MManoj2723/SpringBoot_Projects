package com.mm.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="MP_CURD_Product")
@Data
@NoArgsConstructor
@AllArgsConstructor

//@SQLDelete(sql="UPDATE MP_CURD_PRODUCT SET ACTIVE_SW='inactive' WHERE PID=? AND UPDATE_COUNT=?")
//@SQLRestriction("ACTIVE_SW<>'inactive'")
@SoftDelete
@EntityListeners(AuditingEntityListener.class)
public class ProductEntity {
		@Id
		@SequenceGenerator(name="gen1",sequenceName = "pId_seq",initialValue = 1,allocationSize = 1)
		@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
		private Integer pid;
		
		@Column(length = 25)
		private String pname;
		
		
		private Double pprice;
		
		@Column(length = 25)
		private String pcountry;
		
		
		
		//metaProperties
		
		@Version
		private Integer updateCount;
		
		@CreatedDate
		@Column(updatable=false,insertable = true)
		private LocalDate createdOn;
		
		
		@UpdateTimestamp
		@Column(updatable = true,insertable = false)
		private LocalDateTime lastAccessedOn;
		
		
//		@Column(length=25)
//		private String active_SW="active";
		
		
		@Column(length=25,updatable = false,insertable = true)
		private String createdBy;
		
		
		@Column(length=25,updatable = true,insertable = false)
		private String updatedBy;
		
		
}



















