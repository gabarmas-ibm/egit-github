/******************************************************************************
 *  Copyright (c) 2016 IBM Corp.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *    Gabriel Lopez de Armas (IBM Corp.) - Extend for GitHub Enterprise API
 *****************************************************************************/
package org.eclipse.egit.github.core;

import java.io.Serializable;
import java.util.Date;

/**
 * GitHub Enterprise License model class.
 * @see <a href="https://developer.github.com/enterprise/2.4/v3/enterprise/license/">License API
 * 		information</a>
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

	public int getSeatsUsed() {
		return seatsUsed;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public String getKind() {
		return kind;
	}

	public int getDaysUntilExpiration() {
		return daysUntilExpiration;
	}

	public Date getExpireAt() {
		return expireAt;
	}
}
