package unosim;

public class TypeTest {

	public static void main(String[] args) {
		
		Type dog = new Type(17, "dog");
		Type spider = new Type(200, "spider");
		Type wizard = new Type(0, "wizard");
		Type husky = new Type(170, "husky");
		Type pit = new Type(171, "pit");
		dog.addSubType(husky);
		dog.addSubType(pit);
		
		TypeSpace ecosystem = new TypeSpace("destroy");
		ecosystem.addType(dog);
		ecosystem.addType(spider);
		ecosystem.addType(wizard);
		ecosystem.addType(husky);
		//ecosystem.addType(pit);
		ecosystem.connectTo(0, 1);
		ecosystem.connectTo(0, 0);
		ecosystem.connectTo(1, 0);
		ecosystem.connectTo(2, 0);
		ecosystem.connectTo(2, 2);
		ecosystem.connectTo(3, 2);
		ecosystem.connectTo(3, 1);
		ecosystem.connectTo(3, 3);
		//the .equals method now returns that this new Type is included! (yay)
		System.out.println(ecosystem.contains(new Type(0, "wizard")));
		System.out.println(ecosystem.contains(wizard));
		System.out.println(ecosystem.connects(dog, spider));
		System.out.println(ecosystem.connects(spider, dog));
		System.out.println(ecosystem.connects(wizard, spider));
		System.out.println(ecosystem.connects(wizard, pit));
		System.out.println(ecosystem.connects(spider, dog.evaluate(0)));
		ecosystem.printSpace();
		ecosystem.clearRelations(2);
		ecosystem.printSpace();
		ecosystem.clearAllRelations();
		ecosystem.printSpace();
		
		TypeSpace circus = new TypeSpace("entertain");
		circus.addType(dog);
		circus.printSpace();
	}
	
}
