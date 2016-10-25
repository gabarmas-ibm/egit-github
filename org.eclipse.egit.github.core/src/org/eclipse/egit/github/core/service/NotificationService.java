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
package org.eclipse.egit.github.core.service;

import static org.eclipse.egit.github.core.client.IGitHubConstants.SEGMENT_NOTIFICATIONS;
import static org.eclipse.egit.github.core.client.IGitHubConstants.SEGMENT_SUBSCRIPTION;
import static org.eclipse.egit.github.core.client.IGitHubConstants.SEGMENT_THREADS;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.egit.github.core.Subscription;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.client.GitHubRequest;

/**
 * @see <a href="https://developer.github.com/enterprise/2.7/v3/activity/notifications">GitHub Notifications Documentation</a>
 */
public class NotificationService extends GitHubService {


	public NotificationService() {
		super();
	}


	public NotificationService(GitHubClient client) {
		super(client);
	}

	/**
	 * @see <a href="https://developer.github.com/v3/activity/notifications/#get-a-thread-subscription">GitHub Notifications Documentation</a>
	 */
	public Subscription getSubscription(long threadId)
			throws IOException {
		if (threadId <= 0)
			throw new IllegalArgumentException("Thread ID can't be 0 or negative"); //$NON-NLS-1$

		StringBuilder uri = new StringBuilder(SEGMENT_NOTIFICATIONS);
		uri.append(SEGMENT_THREADS);
		uri.append('/').append(threadId);
		uri.append(SEGMENT_SUBSCRIPTION);
		GitHubRequest request = createRequest();
		request.setUri(uri);
		request.setType(Subscription.class);
		return (Subscription) client.get(request).getBody();
	}


	/**
	 * @see <a href="https://developer.github.com/v3/activity/notifications/#set-a-thread-subscription">GitHub Notifications Documentation</a>
	 */
	public Subscription subscribe(long threadId)
			throws IOException {
		return setSubscription(threadId, true, false);
	}

	/**
	 * @see <a href="https://developer.github.com/v3/activity/notifications/#set-a-thread-subscription">GitHub Notifications Documentation</a>
	 */
	public Subscription setSubscription(long threadId, boolean subscribed, boolean ignored)
			throws IOException {
		if (threadId <= 0)
			throw new IllegalArgumentException("Thread ID can't be 0 or negative"); //$NON-NLS-1$

		StringBuilder uri = new StringBuilder(SEGMENT_NOTIFICATIONS);
		uri.append(SEGMENT_THREADS);
		uri.append('/').append(threadId);
		uri.append(SEGMENT_SUBSCRIPTION);

		Map<String, Object> params = new HashMap<String, Object>(){{
			put("subscribed", subscribed); //$NON-NLS-1$
			put("ignored", ignored); //$NON-NLS-1$
		}};

		return (Subscription) client.post(uri.toString(), params, Subscription.class);
	}

}
