package src;
public class Source {

	private String content;
	private int pointer;

	public Source(String fileName) throws Exception {
		FileReader reader = new FileReader(fileName);
		this.content = reader.read();
	}

	public int getSize() {
		int position, size = 0;

		position = this.content.indexOf('\n');
		while (position != -1){
			size++;
			// se puede usar position+1 sin problema - consultar doc indexOf
			position = this.content.indexOf('\n', position+1);
		}
		return size;
	}

	public void first() {
		this.pointer = 0;
	}

	public String getNext() {
		String line;
		int lineEnd;
		lineEnd = this.content.indexOf('\n', this.pointer);
		line = this.content.substring(this.pointer, lineEnd);
		this.pointer = lineEnd + 1;
		return line;
	}

	public boolean hasNext() {
		return this.content.indexOf('\n', this.pointer) != -1;
	}

	@Override
	public String toString() {
		return this.content;
	}

}
