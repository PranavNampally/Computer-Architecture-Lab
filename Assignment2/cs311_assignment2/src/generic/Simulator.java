package generic;

import java.io.FileInputStream;
import generic.Operand.OperandType;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.nio.ByteBuffer;

public class Simulator {
		
	static FileInputStream inputcodeStream = null;
	
	public static void setupSimulation(String assemblyProgramFile)
	{	
		int firstCodeAddress = ParsedProgram.parseDataSection(assemblyProgramFile);
		ParsedProgram.parseCodeSection(assemblyProgramFile, firstCodeAddress);
		ParsedProgram.printState();
	}
	
	public static void assemble(String objectProgramFile)
	{
		//TODO your assembler code	
		try(
			//1. open the objectProgramFile in binary mode
			FileOutputStream output_file=new FileOutputStream(objectProgramFile);
			BufferedOutputStream buffer_file = new BufferedOutputStream(output_file);
		){
			//2. write the firstCodeAddress to the file
			int firstCode=ParsedProgram.firstCodeAddress;
			byte[] firstCodew = ByteBuffer.allocate(4).putInt(firstCode).array();
			buffer_file.write(firstCodew);
//			System.out.println(firstCodew);
			
			for(int i=0; i<ParsedProgram.data.size(); i++) {
				//3. write the data to the file
				int temp=ParsedProgram.data.get(i);
				byte[] tempw = ByteBuffer.allocate(4).putInt(temp).array();
				buffer_file.write(tempw);
			}
			
			String [] all_inst= {"add", "addi", "sub", "subi", "mul", "muli", "div", "divi", "and", "andi", "or", "ori", "xor", "xori", "slt", "slti", "sll", "slli", "srl", "srli", "sra", "srai", "load", "store", "jmp", "beq", "bne", "blt", "bgt", "end"};
			//4. assemble one instruction at a time, and write to the file
			for(int i=0; i<ParsedProgram.code.size();i++) {
				Instruction current_inst=ParsedProgram.code.get(i);
//				System.out.println(current_inst);
				int inst_index=Arrays.asList(all_inst).indexOf(String.valueOf(current_inst.operationType));
//				System.out.println(inst_index);
				
				String opcode=Integer.toBinaryString(inst_index);
				String binary_op;
				long long_num;
				int num;
				byte[] numw;
				switch(inst_index) {
				case 22:
					//load - R2I
					String rs1=String.format("%" + 5 + "s",	Integer.toBinaryString(current_inst.getSourceOperand1().value)).replaceAll(" ", "0");
					String rd=String.format("%" + 5 + "s",	Integer.toBinaryString(current_inst.getDestinationOperand().value)).replaceAll(" ", "0");
					String imm=String.format("%" + 17 + "s",	Integer.toBinaryString(current_inst.getSourceOperand2().value)).replaceAll(" ", "0");
					binary_op=opcode+rs1+rd+imm;
					
					long_num=Long.parseLong(binary_op,2);	 //long value of the number
					num=(int) long_num; 					 //typecasting to signed int having 32 bits
					System.out.println(num);
					
					numw = ByteBuffer.allocate(4).putInt(num).array();
					buffer_file.write(numw);
					break;
				case 29:
					String zeroes="000000000000000000000000000";
					binary_op=opcode+zeroes;
//					System.out.println(binary_op);
					
					long_num=Long.parseLong(binary_op,2);	 //long value of the number
					num=(int) long_num; 					 //typecasting to signed int having 32 bits
					System.out.println(num);
					
					numw = ByteBuffer.allocate(4).putInt(num).array();
					buffer_file.write(numw);
					break;
				
				default:
					System.out.println("Invalid instruction");
					break;
				}
			}
			
			
			
			
			
			
			//5. close the file
			buffer_file.close();
		}
		catch(IOException error){
			error.printStackTrace();
		}
		
		
		
		
		
	}
	
}