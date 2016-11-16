package myEjb;

import javax.ejb.Stateful;

@Stateful
public class MySecondBeanImpl implements MySecondBean {
	private int state = 10;

	@Override
	public int getState() {
		return state;
	}
}
