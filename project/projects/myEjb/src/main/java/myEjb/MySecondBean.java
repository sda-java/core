package myEjb;

import javax.ejb.Local;

@Local
public interface MySecondBean {
	int getState();
}
