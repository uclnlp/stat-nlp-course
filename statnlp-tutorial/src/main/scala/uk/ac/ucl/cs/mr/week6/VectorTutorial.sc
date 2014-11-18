import cc.factorie.la.{DenseTensor1, GrowableSparseTensor1, SparseTensor1}

import scala.util.Random
val rand = new Random(0l)

//sparse vector used for features
val f = new SparseTensor1(1000000)
f.update(45, 1.0)
f.update(14566, 1.0)

//dense vector used for weights
val w = new DenseTensor1(f.size)
for (i <- 0 until w.length) {
  w.update(i, rand.nextDouble())
}

//many existing methods on vectors, like dot product
f dot w //shorthand for f.dot(w)


//what if you don't know the size of the feature space in advance?
val fGrow = new GrowableSparseTensor1(Nil)
fGrow._indices.max

for {
  i <- 0 until 1000
  if rand.nextDouble() < 0.1
} {
  fGrow += (i, 1.0)
}

fGrow
fGrow._indices.max


//syntactic sugar
type DenseVector = DenseTensor1
type SparseVector = GrowableSparseTensor1

val fNew = new SparseVector(Nil)

//after collecting features we know how many weights we need
val wNew = new DenseVector(fNew._indices.max)

