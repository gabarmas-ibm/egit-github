package jetbrains.charisma.persistent.globalSettings.org.eclipse.egit.github.core;

import java.io.Serializable;

/**
 * Repository permissions representation
 */
public class Permissions implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -7716778137240559602L;

	private boolean admin;

	private boolean push;

	private boolean pull;

	public boolean isAdmin() {
		return admin;
	}

	public Permissions setAdmin(boolean admin) {
		this.admin = admin;
		return this;
	}

	public boolean isPush() {
		return push;
	}

	public Permissions setPush(boolean push) {
		this.push = push;
		return this;
	}

	public boolean isPull() {
		return pull;
	}

	public Permissions setPull(boolean pull) {
		this.pull = pull;
		return this;
	}
}
