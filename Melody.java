
public class Melody {
	private Note note;
	private String sheet = "";
	double duration = 0.0;
	int toggleRepeat = 0;
	Queue<Note> melody;
	
	public Melody(Queue<Note> song) {
		melody = song;
	}
	
	public double getTotalDuration() {
		Queue<Note> coda = new ListQueue<Note>();
		int counter = 0;
		while(counter < melody.size()) {
			note = melody.remove();
				if(note.isRepeat() && toggleRepeat == 0) {
					toggleRepeat = 1;
					coda.add(note);
				}else if(note.isRepeat() == false && toggleRepeat == 1) {
					coda.add(note);
				}else if(note.isRepeat() && toggleRepeat == 1) {
					coda.add(note);
					toggleRepeat = 0;
				}
			melody.add(note);
			duration = duration + note.getDuration();
			if(coda.isEmpty() == false && toggleRepeat == 0) {
				while(coda.isEmpty() == false) {
					duration = duration + coda.remove().getDuration();
				}
			}
			counter++;
		}
		return duration;
	}
	
	public String toString() {	
		int counter = 0;
		while(counter < melody.size()) {
			note = melody.remove();
			melody.add(note);
			sheet = sheet + note + "\n";
			counter++;
		}
		return sheet;
	}
	
	public void changeTempo(double tempo) {
		int counter = 0;
		while(counter < melody.size()) {
			note = melody.remove();
			double newTempo = note.getDuration() * tempo;
			note.setDuration(newTempo);
			melody.add(note);
			counter++;
		}
	}
	
	public void reverse() {
		Stack<Note> reverse = new ListStack<Note>();
		while(melody.isEmpty() == false) {
			note = melody.remove();
			reverse.push(note);
		}
		while(reverse.isEmpty() == false) {
			note = reverse.pop();
			melody.add(note);
		}
	}
	
	public void append(Melody other) {
		
		Queue<Note> newMelody = other.melody;
		
		while(newMelody.isEmpty() == false) {
			note = newMelody.remove();
			melody.add(note);
		}
	}
	
	public void play() {
		Queue<Note> coda = new ListQueue<Note>();
		int counter = 0;
		while(counter < melody.size()) {
			note = melody.remove();
				if(note.isRepeat() && toggleRepeat == 0) {
					toggleRepeat = 1;
					coda.add(note);
				}else if(note.isRepeat() == false && toggleRepeat == 1) {
					coda.add(note);
				}else if(note.isRepeat() && toggleRepeat == 1) {
					coda.add(note);
					toggleRepeat = 0;
				}
			melody.add(note);
			note.play();
			if(coda.isEmpty() == false && toggleRepeat == 0) {
				while(coda.isEmpty() == false) {
					note = coda.remove();
					note.play();
				}
			}
			counter++;
		}
	}
	
}
