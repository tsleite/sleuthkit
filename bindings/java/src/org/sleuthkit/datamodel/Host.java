/*
 * Sleuth Kit Data Model
 *
 * Copyright 2021-2021 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.datamodel;

import java.util.Objects;

/**
 *
 * Encapsulates a host.
 */
public class Host {

	private final long id;
	private String name;
	private HostStatus status;

	

	Host(long id, String name) {
		this(id, name, HostStatus.ACTIVE);
	}

	Host(long id, String name, HostStatus status) {
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HostStatus getStatus() {
		return status;
	}
	
	@Override
	public int hashCode() {
		int hash = 5;
		hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
		hash = 67 * hash + Objects.hashCode(this.name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		final Host other = (Host) obj;
		if (this.id != other.id) {
			return false;
		}

		if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
			return false;
		}

		return true;
	}

	/**
	 * Encapsulates status of host row.
	 */
	public enum HostStatus {
		ACTIVE(0, "Active"),
		MERGED(1, "Merged"),
		DELETED(2, "Deleted");
		

		private final int id;
		private final String name;

		HostStatus(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		String getName() {
			return name;
		}

		public static HostStatus fromID(int typeId) {
			for (HostStatus type : HostStatus.values()) {
				if (type.ordinal() == typeId) {
					return type;
				}
			}
			return null;
		}
	}
	
}
