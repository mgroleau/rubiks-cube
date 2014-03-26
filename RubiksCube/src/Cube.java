public class Cube {
	private char[] up = new char[9];
	private char[] down = new char[9];
	private char[] left = new char[9];
	private char[] right = new char[9];
	private char[] front = new char[9];
	private char[] back = new char[9];
	
	public Cube(){
		for(int i=0;i<9;i++)
			up[i] = 'W';
		for(int i=0;i<9;i++)
			down[i] = 'Y';
		for(int i=0;i<9;i++)
			left[i] = 'B';
		for(int i=0;i<9;i++)
			right[i] = 'G';
		for(int i=0;i<9;i++)
			front[i] = 'O';
		for(int i=0;i<9;i++)
			back[i] = 'R';
	}
	
	public void reset(){
		for(int i=0;i<9;i++)
			up[i] = 'W';
		for(int i=0;i<9;i++)
			down[i] = 'Y';
		for(int i=0;i<9;i++)
			left[i] = 'B';
		for(int i=0;i<9;i++)
			right[i] = 'G';
		for(int i=0;i<9;i++)
			front[i] = 'O';
		for(int i=0;i<9;i++)
			back[i] = 'R';
	}

	public char[] getUp() {
		return up;
	}

	public void setUp(char[] up) {
		this.up = up;
	}

	public char[] getDown() {
		return down;
	}

	public void setDown(char[] down) {
		this.down = down;
	}

	public char[] getLeft() {
		return left;
	}

	public void setLeft(char[] left) {
		this.left = left;
	}

	public char[] getRight() {
		return right;
	}

	public void setRight(char[] right) {
		this.right = right;
	}

	public char[] getFront() {
		return front;
	}

	public void setFront(char[] front) {
		this.front = front;
	}

	public char[] getBack() {
		return back;
	}

	public void setBack(char[] back) {
		this.back = back;
	}
	
	public static char[] rotate(char[] face, int ccw){
		char[] rotated = new char[9];
		rotated[4]=face[4];
		if(ccw==0){
			rotated[0]=face[6];
			rotated[1]=face[3];
			rotated[2]=face[0];
			rotated[3]=face[7];
			rotated[5]=face[1];
			rotated[6]=face[8];
			rotated[7]=face[5];
			rotated[8]=face[2];
		}
		else{
			rotated[0]=face[2];
			rotated[1]=face[5];
			rotated[2]=face[8];
			rotated[3]=face[1];
			rotated[5]=face[7];
			rotated[6]=face[0];
			rotated[7]=face[3];
			rotated[8]=face[6];
		}			
		return rotated;
	}
}
