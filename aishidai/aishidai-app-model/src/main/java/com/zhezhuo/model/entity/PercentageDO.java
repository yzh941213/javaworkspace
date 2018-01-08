package com.zhezhuo.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 分成
 */
public class PercentageDO implements Serializable {

	private Long id;
	private Integer sys;
	private Integer distributor;
	private Integer shop;
	private Integer maker;
	private Integer craftsman;

	private Integer sysSer;
	private Integer distributorSer;
	private Integer shopSer;
	private Integer makerSer;
	private Integer craftsmanSer;

	private BigDecimal amount;
	private BigDecimal balance;

	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSys() {
		return sys;
	}

	public void setSys(Integer sys) {
		this.sys = sys;
	}

	public Integer getDistributor() {
		return distributor;
	}

	public void setDistributor(Integer distributor) {
		this.distributor = distributor;
	}

	public Integer getShop() {
		return shop;
	}

	public void setShop(Integer shop) {
		this.shop = shop;
	}

	public Integer getMaker() {
		return maker;
	}

	public void setMaker(Integer maker) {
		this.maker = maker;
	}

	public Integer getCraftsman() {
		return craftsman;
	}

	public void setCraftsman(Integer craftsman) {
		this.craftsman = craftsman;
	}

	public Integer getSysSer() {
		return sysSer;
	}

	public void setSysSer(Integer sysSer) {
		this.sysSer = sysSer;
	}

	public Integer getDistributorSer() {
		return distributorSer;
	}

	public void setDistributorSer(Integer distributorSer) {
		this.distributorSer = distributorSer;
	}

	public Integer getShopSer() {
		return shopSer;
	}

	public void setShopSer(Integer shopSer) {
		this.shopSer = shopSer;
	}

	public Integer getMakerSer() {
		return makerSer;
	}

	public void setMakerSer(Integer makerSer) {
		this.makerSer = makerSer;
	}

	public Integer getCraftsmanSer() {
		return craftsmanSer;
	}

	public void setCraftsmanSer(Integer craftsmanSer) {
		this.craftsmanSer = craftsmanSer;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
