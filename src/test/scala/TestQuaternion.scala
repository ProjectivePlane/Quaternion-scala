package quaterniontest

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import quaternion._

class TestQuaternion extends FunSuite with BeforeAndAfter{
      var zero:Quaternion=_
      var one:Quaternion=_
      var two:Quaternion=_
      var minusOne:Quaternion=_
      var i:Quaternion=_
      var j:Quaternion=_
      var k:Quaternion=_
      var a:Quaternion=_
      var b:Quaternion=_
      var c:Quaternion=_
      var d:Quaternion=_
      var aConjugate:Quaternion=_
      var aUnit:Quaternion=_
      var bConjugate:Quaternion=_
      var bUnit:Quaternion=_
      var cConjugate:Quaternion=_
      var cUnit:Quaternion=_
      var dConjugate:Quaternion=_
      var dUnit:Quaternion=_
      
      before{
	zero=new Quaternion
	one=new Quaternion(1)
	two=new Quaternion(2)
	minusOne=new Quaternion(-1)
	i=new Quaternion(0,1)
	j=new Quaternion(0,0,1)
	k=new Quaternion(0,0,0,1)

	a=new Quaternion(0,1,2,3)
	b=new Quaternion(5,4,3,2)
	c=new Quaternion(5,5,5,5)
	d=new Quaternion(-5,-3,-1,1)
	aUnit=new Quaternion(0.0,0.2672612419124244,0.5345224838248488,0.8017837257372732)
	bUnit=new Quaternion(0.6804138174397717,0.5443310539518174,0.408248290463863,0.2721655269759087)
	cUnit=new Quaternion(0.5,0.5,0.5,0.5)
	dUnit=new Quaternion(-0.8333333333333334,-0.5,-0.16666666666666666,0.16666666666666666)
	aConjugate=new Quaternion(0,-1,-2,-3)
	bConjugate=new Quaternion(5,-4,-3,-2)
	cConjugate=new Quaternion(5,-5,-5,-5)
	dConjugate=new Quaternion(-5,3,1,-1)
      }

      test("zero.toString"){
	assert(zero.toString=="(0.0,0.0,0.0,0.0)")
      }

      test("zero+one"){
	assert(zero+one==one)
      }

      test("a+b==c"){
	assert(a+b==c)
      }

      test("a-b==d"){
	assert(a-b==d)
      }

      test("minus one"){
      	assert(-one==minusOne)
      }

      test("i*j==k"){
	assert(i*j==k)
      }

      test("j*i==-k"){
	assert(j*i== -k)
      }

      test("j*k==i"){
	assert(j*k==i)
      }

      test("k*j==-i"){
	assert(k*j== -i)
      }

      test("k*i==j"){
	assert(k*i== j)
      }

      test("i*k==-j"){
	assert(i*k== -j)
      }

      test("i*i==-1"){
      	assert(i*i== -one)
      }

      test("j*j==-1"){
      	assert(j*j== -one)
      }

      test("k*k==-1"){
      	assert(k*k== -one)
      }

      test("i*j*k==-1"){
      	assert(i*j*k== -one)
      }

      test("k*j*i==1"){
      	assert(k*j*i== one)
      }

      test("a.conjugate"){
        assert(a.conjugate==aConjugate)
      }

      test("a.~"){
        assert(~a==aConjugate)
      }

      test("b.conjugate"){
        assert(b.conjugate==bConjugate)
      }

      test("b.~"){
        assert(~b==bConjugate)
      }

      test("c.conjugate"){
        assert(c.conjugate==cConjugate)
      }

      test("c.~"){
        assert(~c==cConjugate)
      }

      test("d.conjugate"){
        assert(d.conjugate==dConjugate)
      }

      test("d.~"){
        assert(~d==dConjugate)
      }

      test("zero.norm"){
	assert(zero.norm==0)
      }

      test("one.norm"){
	assert(one.norm==1)
      }

      test("one.reciprocal"){
	assert(one.reciprocal==one)
      }

      test("i.reciprocal"){
	assert(i.reciprocal== -i)
      }

      test("j.reciprocal"){
	assert(j.reciprocal== -j)
      }

      test("k.reciprocal"){
	assert(k.reciprocal== -k)
      }

      test("i/i"){
	assert(i/i== one)
      }

      test("j/j"){
	assert(j/j== one)
      }

      test("k/k"){
	assert(k/k== one)
      }

      test("a.unit"){
	assert(a.unit==aUnit)
      }
      
      test("b.unit"){
	assert(b.unit==bUnit)
      }

      test("c.unit"){
	assert(c.unit==cUnit)
      }

      test("d.unit"){
	assert(d.unit==dUnit)
      }

      test("zero.unit"){
	assert(zero.unit==zero)
      }

      test("one.scalarMult(2)"){
	assert(one.scalarMult(2)==two)
      }

      test("one.scalarMult(-1)"){
	assert(one.scalarMult(-1)==minusOne)
      }

      test("zero.exp"){
	assert(zero.exp==one)
      }

      test("one.log"){
	assert(one.ln==zero)
      }
}