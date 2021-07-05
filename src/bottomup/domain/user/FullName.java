package bottomup.domain.user;

public class FullName {
	
	// 値オブジェクトはイミュータブルであるなら、finalをつけるのが良さそうだなあ
	private final String familyName;
	private final String lastName;

	public FullName(String familyName, String lastName) {
		this.familyName = familyName;
		this.lastName = lastName;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	
	public String getLastName() {
		return lastName;
	}

	// eclipseが生成してくれるから便利だなあ
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((familyName == null) ? 0 : familyName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FullName other = (FullName) obj;
		if (familyName == null) {
			if (other.familyName != null)
				return false;
		} else if (!familyName.equals(other.familyName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
}
