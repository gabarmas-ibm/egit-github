/*******************************************************************************
 *  Copyright (c) 2011 GitHub Inc.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *    Kevin Sawicki (GitHub Inc.) - initial API and implementation
 *******************************************************************************/
package org.eclipse.egit.github.core;

import java.io.Serializable;
import java.util.Date;

/**
 * GitHub Enterprise License model class.
 */
public class License implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 4558167750192501152L;

	private int seats;

	private int seatsUsed;

	private int seatsAvailable;

	private String kind;

	private int daysUntilExpiration;

	private Date expireAt;

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getSeatsUsed() {
		return seatsUsed;
	}

	public void setSeatsUsed(int seatsUsed) {
		this.seatsUsed = seatsUsed;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getDaysUntilExpiration() {
		return daysUntilExpiration;
	}

	public void setDaysUntilExpiration(int daysUntilExpiration) {
		this.daysUntilExpiration = daysUntilExpiration;
	}

	public Date getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(Date expireAt) {
		this.expireAt = expireAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
