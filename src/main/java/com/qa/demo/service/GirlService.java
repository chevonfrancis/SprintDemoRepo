@Service //stores main bsuiness logic of the application
public class GirlService {

	//LIST - WE havent got DB yet so we need to store data somewhere 
	//private List<Girl> girlies = new ArrayList<>(); dont need in here any more as we are going in the (girlrepo)
	
	private GirlRepository repo;
	
	public GirlService(GirlRepository repo) {
		this.repo = repo;
	}
	
	//CRUD Functionality 
	public Girl createGirl(Girl g) {
	Girl created = this.repo.save(g);	
//	this.girlies.add(g);
//	Girl created = this.girlies.get(this.girlies.size()-1);
	return created;
	}
	
	 public List<Girl> getAllGirlies() {
//		 return this.girlies;
		 return this.repo.findAll();
	 }
	 
	 public Girl getGirl(Integer id) {
//		 return this.girlies.get(id);
		Optional <Girl> found = this.repo.findById(id);
		return found.get();
	 }
	 
	 public Girl replaceGirl(Integer id, Girl newGirl) {
//		 Girl body = this.girlies.set(id, newGirl);
//		 return body;
		 Girl existing = this.repo.findById(id).get();
		 existing.setAge(newGirl.getAge());
		 existing.setHairColor(newGirl.getHairColor());
		 existing.setName(newGirl.getName());
		 Girl updated = this.repo.save(existing);
		 return updated;
	 }
	 
	public void removeGirl(@PathVariable Integer id) {
//		this.girlies.remove(id.intValue());
		this.repo.deleteById(id);
	}
	 
	
}
