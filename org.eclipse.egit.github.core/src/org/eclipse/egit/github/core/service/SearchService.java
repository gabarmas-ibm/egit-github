package org.eclipse.egit.github.core.service;

import static org.eclipse.egit.github.core.client.IGitHubConstants.CHARSET_UTF8;
import static org.eclipse.egit.github.core.client.IGitHubConstants.SEGMENT_SEARCH;
import static org.eclipse.egit.github.core.client.IGitHubConstants.SEGMENT_USER;
import static org.eclipse.egit.github.core.client.IGitHubConstants.SEGMENT_USERS;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.client.GitHubRequest;

public class SearchService extends GitHubService {

	/**
	 * Create user service
	 */
	public SearchService() {
		super();
	}

	/**
	 * Create user service
	 *
	 * @param client
	 */
	public SearchService(GitHubClient client) {
		super(client);
	}
	public User getUser() throws IOException {
		GitHubRequest request = createRequest();
		request.setUri(SEGMENT_USER);
		request.setType(User.class);
		return (User) client.get(request).getBody();
	}
	/**
	 * Get user with given login name
	 *
	 * @param login
	 * @return user
	 * @throws IOException
	 */
	public UserResults searchUser(String query) throws IOException {
		if (query == null)
			throw new IllegalArgumentException("Query can't be null"); //$NON-NLS-1$

		GitHubRequest request = createRequest();
		StringBuilder uri = new StringBuilder(SEGMENT_SEARCH + SEGMENT_USERS);
		final String encodedQuery = URLEncoder.encode(query, CHARSET_UTF8);
		uri.append("?q=").append(encodedQuery);
		System.out.println(uri);
		request.setUri(uri);
		request.setType(UserResults.class);
		return  (UserResults) client.get(request).getBody();
	}

	public static class UserResults {
		private int totalCount;
		private List<User> items;

		public int getTotalCount(){
			return totalCount;
		}

		public List<User> getItems(){
			return items;
		}
	}

}
