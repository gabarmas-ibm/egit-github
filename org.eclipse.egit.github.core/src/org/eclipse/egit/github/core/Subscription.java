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

/**Subscription object for the Notifications API
 * See example:
 * @see <a href="https://developer.github.com/enterprise/2.7/v3/activity/notifications/#get-a-thread-subscription">Subscription object</a>
 * @author gabarmas@ie.ibm.com
 *
 */
public class Subscription implements Serializable{

	private static final long serialVersionUID = -4415851012052269086L;

	private boolean subscribed;

	private boolean ignored;

	private String reason;

	private Date createdAt;

	private String url;

	private String threadUrl;

	public boolean isSubscribed() {
		return subscribed;
	}

	public boolean isIgnored() {
		return ignored;
	}

	public String getReason() {
		return reason;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getUrl() {
		return url;
	}

	public String getThreadUrl() {
		return threadUrl;
	}

	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

	public void setIgnored(boolean ignored) {
		this.ignored = ignored;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setThreadUrl(String threadUrl) {
		this.threadUrl = threadUrl;
	}

}
