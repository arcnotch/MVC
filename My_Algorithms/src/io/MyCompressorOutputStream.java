package io;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/**
 * @author Tal Mishaan 203908652 And Guy Binyamin 200958098
 *
 */
public class MyCompressorOutputStream extends OutputStream {

	private OutputStream out;
	
	/**
	 * Constructor
	 * @param out OutputStream This is the output stream to write to
	 */
	public MyCompressorOutputStream(OutputStream out) {
		super();
		this.out = out;
	}
	
	@Override
	public void write(byte[] byte_array){
		int counter = 0;
		byte last = 0;
		
		int size = byte_array.length;
		byte[] array_size = ByteBuffer.allocate(4).putInt(size).array();
		
		for (byte a : array_size){
			try {
				out.write(a);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		for (int i = 0; i < byte_array.length; i++){
			if(byte_array[i] != last){
				
				try {
					if(counter > 0){
						out.write(last);
						out.write(counter);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				last = byte_array[i];
				counter = 1;
				
			}else{
				counter++;
				
				if(counter == 255){
					try {
						out.write(last);
						out.write(counter);
					} catch (IOException e) {
						e.printStackTrace();
					}
				
					counter = 0;
				}
			}
		}
		
		if(counter > 0){
			try {
				out.write(last);
				out.write(counter);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void write(int b) throws IOException {
		out.write((byte) b);
	}
}