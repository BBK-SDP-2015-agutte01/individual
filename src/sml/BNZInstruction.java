package sml;

/**
 * This class is for Branch Not Zero (jump) instructions
 * 
 * 1 register is provided as a constructor argument and is 
 * checked to see if the contents are zero. If not, the statement
 * number provided as the other constructor argument is executed.
 * 
 * @author agutteridge
 */

public class BNZInstruction extends Instruction {

	private int reg;
	private String statement;

	public BNZInstruction(String label, String op) {
		super(label, op);
	}

	public BNZInstruction(String label, int reg, String statement) {
		this(label, "bnz");
		this.reg = reg;
		this.statement = statement;
	}

	@Override
	public void execute(Machine m) {
		if (m.getRegisters().getRegister(reg) != 0) {
			int newPcValue = Integer.parseInt(statement.substring(1));
			m.setPc(newPcValue);
		}
	}

	@Override
	public String toString() {
		return super.toString() + " " + reg + "? JUMP to " + statement;			
	}
}