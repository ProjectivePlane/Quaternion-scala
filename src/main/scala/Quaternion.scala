package quaternion

class Quaternion(rp:Double=0,ip:Double=0,jp:Double=0,kp:Double=0){
      var r=rp
      var i=ip
      var j=jp
      var k=kp
      
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
}