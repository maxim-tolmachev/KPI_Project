import 
public class DataPArserTest{
  @test
  public  test(){
  DataPArser datapars = new DataPArser (); 
  assertThat(datapars.handleSymbol()).isZero(); 
  datapars.reset(); 
  assertThat(datapars.getTypeofParser()).isEqualTo(10); 
  datapars.reset(); 
  assertThat(datapars.handleEof()throws Exception);
  }
}
