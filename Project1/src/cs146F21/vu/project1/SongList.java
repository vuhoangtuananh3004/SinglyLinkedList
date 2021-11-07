package cs146F21.vu.project1;

/**
 * Object of class SongList store Song information
 */
public class SongList implements Comparable<Integer> {
	private int id;
	private String name;

	public SongList(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Integer o) {
		int result = (getId() == o) ? 1 : 0;
		return result;
	}

	@Override
	public String toString() {
		return "SongList [id=" + id + ", name=" + name + "]";
	}

}
