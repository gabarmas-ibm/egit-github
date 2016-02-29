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

import static org.eclipse.egit.github.core.client.IGitHubConstants.SEGMENT_ENTERPRISE;
import static org.eclipse.egit.github.core.client.IGitHubConstants.SEGMENT_LICENSE;
import static org.eclipse.egit.github.core.client.IGitHubConstants.SEGMENT_SETTINGS;

import java.io.IOException;

import org.eclipse.egit.github.core.License;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.client.GitHubRequest;

/**
 * Enterprise service class
 *
 * @see <a href="https://developer.github.com/v3/enterprise">GitHub Enterprise API
 *      documentation</a>
 */
public class AdminService extends GitHubService {

	/**
	 * Create Enterprise service
	 */
	public AdminService() {
		super();
	}

	/**
	 * Create Enterprise  service
	 *
	 * @param client
	 */
	public AdminService(GitHubClient client) {
		super(client);
	}


	/**
	 * Get Enterprise License Info
	 * https://developer.github.com/v3/enterprise/license/
	 */
	public License getLicenseInfo() throws IOException {
		StringBuilder uri = new StringBuilder(SEGMENT_ENTERPRISE + SEGMENT_SETTINGS + SEGMENT_LICENSE);
		GitHubRequest request = createRequest();
		request.setUri(uri);
		request.setType(License.class);
		return (License) client.get(request).getBody();
	}


}
