package quaternion

class Quaternion(rp:Double=0,ip:Double=0,jp:Double=0,kp:Double=0){
      private var _r=rp
      private var _i=ip
      private var _j=jp
      private var _k=kp

      //Getters
      def r=_r
      def i=_i
      def j=_j
      def k=_k

      //Setters
      def r_(value:Double):Unit = _r=value
      def i_(value:Double):Unit = _i=value
      def j_(value:Double):Unit = _j=value
      def k_(value:Double):Unit = _k=value

      override def toString="("+r+","+i+","+j+","+k+")"

      def +(q:Quaternion)=new Quaternion(r+q.r,i+q.i,j+q.j,k+q.k)

      def -(q:Quaternion)=new Quaternion(r-q.r,i-q.i,j-q.j,k-q.k)

      def conjugate=new Quaternion(r,-i,-j,-k)

      def norm=math.sqrt(r*r+i*i+j*j+k*k)

      def reciprocal=new Quaternion(r/this.norm,-i/this.norm,-j/this.norm,-k/this.norm)

      def /(q:Quaternion)=this*q.reciprocal

      override def equals(q:Any)=q.isInstanceOf[Quaternion] && (r==q.asInstanceOf[Quaternion].r)&&(i==q.asInstanceOf[Quaternion].i)&&(j==q.asInstanceOf[Quaternion].j)&&(k==q.asInstanceOf[Quaternion].k)

      def unary_- =new Quaternion(-r,-i,-j,-k)

      def unary_~ = this.conjugate

      def *(q:Quaternion)=new Quaternion(r*q.r-i*q.i-j*q.j-k*q.k,
					r*q.i+i*q.r+j*q.k-k*q.j,
					r*q.j-i*q.k+j*q.r+k*q.i,
					r*q.k+i*q.j-j*q.i+k*q.r)

      def unit={
      	  var norm:Quaternion=new Quaternion(this.r/this.norm,this.i/this.norm,this.j/this.norm,this.k/this.norm)
	        if(this.norm>0){
		          norm
	        }else{
		          this
	        }
	}

      def scalarMult(scalar:Double)=new Quaternion(this.r*scalar,this.i*scalar,this.j*scalar,this.k*scalar)


      def exp={
      	  var scalingFactor:Double=math.exp(this.r)
	        var vecComponent:Quaternion=new Quaternion(0,this.i,this.j,this.k)
	        var vecComponentNorm:Double=vecComponent.norm
	        var vecComponentUnit:Quaternion=vecComponent.unit
	        var realComponent:Quaternion=new Quaternion(math.cos(vecComponentNorm))
	        var intermediateQuaternion=realComponent+vecComponentUnit.scalarMult(math.sin(vecComponentNorm))
	        var result:Quaternion=intermediateQuaternion.scalarMult(scalingFactor)
	        result
      }

      def ln={
      	  var vecScalingFactor:Double=math.acos(this.r/this.norm)
	        var realComponent:Quaternion=new Quaternion(math.log(this.norm))
	        var vecComponent:Quaternion=new Quaternion(0,this.i,this.j,this.k)
	        var result=realComponent+vecComponent.scalarMult(vecScalingFactor)
	        result
      }

      def withR(value:Double):Quaternion={
          this._r=value
          this
      }

      def withI(value:Double):Quaternion={
          this._i=value
          this
      }

      def withJ(value:Double):Quaternion={
          this._j=value
          this
      }

      def withK(value:Double):Quaternion={
          this._k=value
          this
      }
}
