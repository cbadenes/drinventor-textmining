{
  "uri" : "sig2009-a29-wang_PROC.xml",
  "url" : "/Users/cbadenes/Documents/OEG/Projects/DrInventor/datasets/acm-siggraph-2006-2014-upf/sig2009/a29-wang_PROC.xml",
  "source" : {
    "name" : "SIGGRAPH",
    "uri" : "http://drinventor/SIGGRAPH",
    "url" : "http://drinventor/SIGGRAPH",
    "protocol" : "http"
  },
  "metainformation" : {
    "title" : "Kernel Nystr?m Method for Light Transport",
    "published" : null,
    "format" : "pdf",
    "language" : "en",
    "rights" : "GPLv2",
    "description" : "",
    "creators" : [ ]
  },
  "bagOfWords" : [ "we", "propose", "kernel", "nystr?m", "method", "reconstruct", "light", "transport", "matrix", "from", "relatively", "small", "number", "acquire", "image", "we", "work", "base", "generalize", "nystr?m", "method", "low", "rank", "matrix", "we", "introduce", "light", "transport", "kernel", "incorporate", "nystr?m", "method", "exploit", "nonlinear", "coherence", "light", "transport", "matrix", "we", "also", "develop", "adaptive", "scheme", "efficiently", "capture", "sparsely", "sample", "image", "from", "scene", "we", "experiment", "indicate", "kernel", "nystr?m", "method", "can", "achieve", "good", "reconstruction", "light", "transport", "matrix", "few", "hundred", "image", "produce", "high", "quality", "relighting", "result", "goal", "image-based", "relighting", "directly", "capture", "light", "transport", "real-world", "scene", "so", "can", "render", "new", "illumination", "-lsb-", "Debevec", "et", "al.", "2000", "Wenger", "et", "al.", "2005", "Peers", "et", "al.", "2009", "-rsb-", "mathematically", "image-based", "relighting", "can", "formulate", "following", "equation", "-lsb-", "ng", "et", "al.", "2003", "Peers", "et", "al.", "2009", "-rsb-", "we", "task", "find", "matrix", "t.", "image-based", "relighting", "offer", "unparalleled", "advantage", "realistic", "render", "without", "scene", "modeling", "which", "often", "arduous", "task", "several", "approach", "have", "show", "promise", "reduce", "number", "require", "image", "-lsb-", "Zongker", "et", "al.", "1999", "Matusik", "et", "al.", "2004", "peer", "Dutr", "2005", "Peers", "et", "al.", "2009", "Sen", "Darabi", "2009", "-rsb-", "however", "technique", "either", "dedicate", "specific", "light", "transport", "effect", "-lsb-", "Zongker", "et", "al.", "1999", "-rsb-", "mainly", "effective", "scene", "simple", "geometry", "configuration", "-lsb-", "Matusik", "et", "al.", "2004", "peer", "Dutr", "2005", "-rsb-", "apply", "technique", "scene", "complex", "lighting", "effect", "occlusion", "still", "require", "large", "number", "input", "image", "expensive", "reconstruction", "method", "-lsb-", "peer", "et", "al.", "2009", "-rsb-", "paper", "we", "propose", "kernel", "nystr?m", "method", "reconstruct", "light", "transport", "matrix", "from", "small", "number", "image", "we", "first", "acquire", "small", "number", "row", "column", "light", "transport", "matrix", "real", "world", "scene", "reconstruct", "entire", "matrix", "from", "sparse", "sample", "we", "work", "inspire", "nystr?m", "method", "propose", "Williams", "Seeger", "-lsb-", "2000", "-rsb-", "reconstruct", "low", "rank", "symmetric", "matrix", "use", "linear", "combination", "sparsely", "sample", "row", "column", "paper", "we", "apply", "generalized", "form", "nystr?m", "method", "-lsb-", "Goreinov", "et", "al.", "1997", "-rsb-", "previously", "develop", "linear", "algebra", "community", "reconstruct", "asymmetrical", "matrix", "main", "contribution", "paper", "introduction", "light", "transport", "kernel", "so", "nonlinear", "coherence", "light", "transport", "matrix", "can", "exploit", "enhance", "effectiveness", "nystr?m", "method", "power", "nystr?m", "method", "essentially", "come", "from", "its", "ability", "exploit", "linear", "coherence", "light", "transport", "matrix", "first", "we", "design", "datum", "specific", "kernel", "function", "can", "estimate", "from", "sparse", "row", "column", "sample", "map", "sample", "kernel", "function", "we", "reduce", "rank", "light", "transport", "matrix", "so", "high", "quality", "matrix", "can", "reconstruct", "from", "kernel-mapped", "sparse", "sample", "via", "nystr?m", "method", "finally", "light", "transport", "matrix", "obtain", "from", "element", "reconstructed", "matrix", "inverse", "kernel", "mapping", "novel", "aspect", "kernel", "nystr?m", "method", "exploit", "datum", "coherence", "during", "matrix", "reconstruction", "process", "before", "whole", "matrix", "know", "have", "be", "recognize", "past", "datum", "coherence", "light", "transport", "can", "use", "datum", "compression", "after", "whole", "matrix", "known", "-lsb-", "masselus", "et", "al.", "2004", "Mahajan", "et", "al.", "2007", "-rsb-", "kernel", "nystr?m", "method", "take", "different", "approach", "only", "use", "known", "row", "column", "sample", "oracle", "analyze", "datum", "coherence", "reconstruct", "matrix", "end", "we", "develop", "adaptive", "scheme", "measure", "sparse", "row", "column", "image", "light", "transport", "matrix", "estimate", "light", "transport", "kernel", "we", "also", "use", "method", "measure", "light", "transport", "between", "object", "surface", "point", "due", "diffuse", "subsurface", "scattering", "inside", "object", "volume", "we", "experiment", "indicate", "kernel", "nystr?m", "method", "can", "achieve", "good", "reconstruction", "light", "transport", "matrix", "few", "hundred", "image", "produce", "high", "quality", "relighting", "result", "moreover", "kernel", "nystr?m", "method", "effective", "modeling", "scene", "complex", "lighting", "effect", "occlusion", "which", "have", "remain", "challenging", "exist", "technique", "complete", "8d", "reflectance", "field", "which", "describe", "light", "transport", "from", "incident", "light", "field", "outgoing", "light", "field", "-lsb-", "levoy", "Hanrahan", "1996", "-rsb-", "difficult", "capture", "process", "-lsb-", "Garg", "et", "al.", "2006", "-rsb-", "paper", "we", "focus", "4d", "reflectance", "field", "fix", "viewpoint", "point", "light", "source", "lie", "2d", "plane", "brute", "force", "method", "directly", "measure", "light", "transport", "matrix", "from", "scene", "where", "each", "column", "image", "scene", "light", "single", "light", "source", "incident", "light", "domain", "all", "method", "require", "ten", "thousand", "image", "modeling", "high", "quality", "light", "transport", "matrix", "thus", "light", "transport", "matrix", "can", "reconstruct", "derive", "sparse", "basis", "weight", "each", "row", "from", "set", "image", "capture", "under", "special", "lighting", "condition", "reconstruction", "process", "also", "time", "consuming", "asymmetric", "matrix", "Goreinov", "et", "al.", "-lsb-", "1997", "-rsb-", "present", "pseudoskeleton", "approximation", "reconstruct", "complete", "matrix", "from", "sparse", "collection", "its", "row", "column", "approach", "only", "use", "coherence", "between", "column", "approximate", "matrix", "section", "we", "first", "review", "generalize", "nystr?m", "method", "asymmetric", "matrix", "-lsb-", "Goreinov", "et", "al.", "1997", "-rsb-", "introduce", "we", "kernel", "nystr?m", "method", "we", "discuss", "how", "capture", "individual", "row", "column", "from", "real", "world", "scene", "next", "section", "give", "matrix", "its", "element", "row", "column", "denote", "while", "-lrb-", "-rrb-", "denote", "matrix", "obtain", "apply", "each", "element", "matrix", "nystr?m", "method", "-lsb-", "Williams", "Seeger", "2000", "-rsb-", "reconstruct", "low", "rank", "symmetric", "matrix", "from", "sparsely", "sample", "column", "show", "figure", "-lrb-", "-rrb-", "unknown", "-lrb-", "-rrb-", "-lrb-", "-rrb-", "symmetric", "matrix", "sample", "row", "-lsb-", "-rsb-", "can", "approximate", "asymmetric", "light", "transport", "matrix", "which", "image", "pixel", "-lrb-", "column", "-rrb-", "light", "source", "-lrb-", "row", "-rrb-", "sample", "different", "space", "generalize", "nystr?m", "method", "-lsb-", "Goreinov", "et", "al.", "1997", "-rsb-", "can", "apply", "reconstruction", "thus", "miss", "portion", "matrix", "can", "reconstruct", "we", "can", "reconstruct", "light", "transport", "matrix", "use", "equation", "both", "traditional", "generalize", "nystr?m", "method", "rely", "assumption", "rank", "identical", "order", "achieve", "exact", "reconstruction", "inspire", "success", "kernel", "trick", "we", "consider", "use", "nonlinear", "function", "change", "value", "entry", "light", "transport", "matrix", "rank", "assumption", "can", "better", "fulfil", "i.e.", "rank", "-lrb-", "-rrb-", "close", "-lrb-", "-rrb-", "possible", "however", "we", "do", "have", "full", "information", "so", "real", "rank", "-lrb-", "-rrb-", "actually", "unknown", "overcome", "difficulty", "we", "choose", "minimize", "rank", "-lrb-", "-rrb-", "instead", "underlie", "philosophy", "rank", "-lrb-", "-rrb-", "much", "less", "than", "min", "-lrb-", "-rrb-", "very", "likely", "rank", "-lrb-", "-rrb-", "do", "exceed", "min", "-lrb-", "-rrb-", "rather", "we", "want", "reduce", "rank", "-lrb-", "-rrb-", "enhance", "linear", "coherence", "rows/columns", "-lrb-", "-rrb-", "however", "trivial", "mapping", "cause", "problem", "invert", "from", "use", "inverse", "function", "so", "we", "have", "we", "show", "necessary", "specify", "what", "two", "point", "set", "however", "without", "any", "knowledge", "about", "light", "transport", "scene", "difficult", "determine", "sample", "number", "advance", "show", "Figure", "we", "focus", "light", "transport", "from", "point", "light", "source", "2d", "plane", "image", "pixel", "capture", "from", "fix", "view", "point", "we", "setup", "column", "light", "transport", "matrix", "directly", "obtain", "from", "image", "scene", "under", "virtual", "point", "light", "source", "while", "row", "matrix", "measure", "via", "dual", "setup", "exploit", "reciprocity", "light", "transport", "-lsb-", "Hawkins", "et", "al.", "2005", "Sen", "et", "al.", "2005", "-rsb-", "obtain", "batch", "row", "column", "we", "first", "capture", "column", "acquire", "row", "light", "transport", "matrix", "we", "take", "image", "diffuser", "plane", "from", "dual", "camera", "simultaneously", "build", "correspondence", "between", "point", "light", "source", "position", "pixel", "dual", "camera", "image", "which", "image", "capture", "dual", "camera", "downsample", "1024", "768", "match", "projector?s", "resolution", "rank", "matrix", "determine", "number", "eigenvalue", "matrix", "can", "preserve", "95.0", "energy", "original", "matrix", "here", "ground", "truth", "submatrix", "element", "sparse", "sample", "set", "same", "submatrix", "element", "reconstruct", "use", "kernel", "nystr?m", "method", "Figure", "11", "compare", "render", "result", "reconstructed", "light", "transport", "matrix", "ground", "truth", "image", "capture", "from", "object", "under", "same", "lighting", "condition", "result", "render", "directly", "interpolate", "nearby", "sample", "image" ],
  "content" : "We propose a kernel Nystr?m method for reconstructing the light transport matrix from a relatively small number of acquired images. Our work is based on the generalized Nystr?m method for low rank matrices. We introduce the light transport kernel and incorporate it into the Nystr?m method to exploit the nonlinear coherence of the light transport matrix. We also develop an adaptive scheme for efficiently capturing the sparsely sampled images from the scene. Our experiments indicate that the kernel Nystr?m method can achieve good reconstruction of the light transport matrix with a few hundred images and produce high quality relighting results. The goal of image-based relighting is to directly capture the light transport of a real-world scene so that it can be rendered with new illumination [Debevec et al. 2000; Wenger et al. 2005; Peers et al. 2009]. Mathematically, image-based relighting can be formulated as the following equation [Ng et al. 2003; Peers et al. 2009]: Our task is to find the matrix T. Image-based relighting offers an unparalleled advantage of realistic rendering without scene modeling, which is often an arduous task. Several approaches have shown promise in reducing the number of required images [Zongker et al. 1999; Matusik et al. 2004; Peers and Dutr? 2005; Peers et al. 2009; Sen and Darabi 2009]. However, these techniques are either dedicated to specific light transport effects [Zongker et al. 1999] or mainly effective with scenes of simple geometry configurations [Matusik et al. 2004; Peers and Dutr? 2005]. Applying these techniques to scenes with complex lighting effects and occlusions still requires a large number of input images and expensive reconstruction methods [Peers et al. 2009]. In this paper we propose a kernel Nystr?m method for reconstructing the light transport matrix from a small number of images. We first acquire a small number of rows and columns of the light transport matrix of a real world scene and then reconstruct the entire matrix from these sparse samples. Our work is inspired by the Nystr?m method proposed by Williams and Seeger [2000] for reconstructing a low rank symmetric matrix using a linear combination of sparsely sampled rows and columns. In this paper, we apply a generalized form of the Nystr?m method [Goreinov et al. 1997] previously developed in the linear algebra community for reconstructing asymmetrical matrices. The main contribution of this paper is the introduction of the light transport kernel so that the nonlinear coherence of the light transport matrix can be exploited to enhance the effectiveness of the Nystr?m method. The power of the Nystr?m method essentially comes from its ability to exploit the linear coherence of the light transport matrix. First, we design a data specific kernel function that can be estimated from the sparse row and column samples. Then by mapping these samples with the kernel function, we reduce the rank of the light transport matrix so that a high quality matrix can be reconstructed from the kernel-mapped sparse samples via the Nystr?m method. Finally, the light transport matrix is obtained from elements of the reconstructed matrix by inverse kernel mapping. A novel aspect of the kernel Nystr?m method is that it exploits the data coherence during the matrix reconstruction process, before the whole matrix is known. It has been recognized in the past that the data coherence in light transport can be used for data compression after the whole matrix is known [Masselus et al. 2004; Mahajan et al. 2007]. The kernel Nystr?m method takes a different approach and only uses the known row and column samples as an oracle for analyzing the data coherence and reconstructing the matrix. To this end, we develop an adaptive scheme for measuring the sparse row and column images of the light transport matrix and estimating the light transport kernel. We also used the method to measure the light transport between object surface points due to diffuse subsurface scattering inside the object volume. Our experiments indicate that the kernel Nystr?m method can achieve good reconstruction of the light transport matrix with a few hundred images and produce high quality relighting results. Moreover, the kernel Nystr?m method is effective for modeling scenes with complex lighting effects and occlusions which have remained challenging for existing techniques. A complete 8D reflectance field, which describes the light transport from the incident light field to the outgoing light field [Levoy and Hanrahan 1996], is difficult to capture and process [Garg et al. 2006]. In this paper, we focus on 4D reflectance fields with a fixed viewpoint and point light sources that lie in a 2D plane. The brute force methods directly measure the light transport matrix from the scene, where each column is an image of the scene lit by a single light source in the incident light domain. All these methods require tens of thousands of images for modeling a high quality light transport matrix. Thus the light transport matrix can be reconstructed by deriving the sparse basis and their weights for each row from a set of images captured under special lighting conditions. The reconstruction process is also time consuming. For asymmetric matrices, Goreinov et. al. [1997] presented a pseudoskeleton approximation for reconstructing a complete matrix from a sparse collection of its rows and columns. This approach only uses the coherence between the columns for approximating the matrix. In this section, we first review the generalized Nystr?m method for asymmetric matrices [Goreinov et al. 1997] and then introduce our kernel Nystr?m method. We will discuss how to capture individual rows and columns from a real world scene in the next section. Given a matrix T, its element at row i and column j is denoted as T i j , while f (T) denotes a matrix obtained by applying f to each element of the matrix T. The Nystr?m method in [Williams and Seeger 2000] reconstructs a low rank symmetric matrix from sparsely sampled columns. As shown in Figure 2(a) , an unknown (n + k) ? (n + k) symmetric matrix T with k sampled rows [ A C T ] can be approximated as For asymmetric light transport matrices in which the image pixels (columns) and light sources (rows) are sampled in different spaces, the generalized Nystr?m method [Goreinov et al. 1997] can be applied for reconstruction. Thus the missing portion B in the matrix T can be reconstructed as: With A + , we can reconstruct the light transport matrix T using Equation 5. Both the traditional and the generalized Nystr?m methods rely on the assumption that the ranks of T and A are identical, in order to achieve an exact reconstruction. Inspired by the success of the kernel trick, we consider using a nonlinear function f to change the values of the entries in light transport matrix T, such that the rank assumption can be better fulfilled, i.e., the rank of f (T) is as close to that of f (A) as possible. However, we do not have the full information on T. So the real rank of f (T) is actually unknown. To overcome this difficulty, we choose to minimize the rank of f (A) instead. The underlying philosophy is that if the rank of f (A) is much less than min(r, c), then it is very likely that the rank of f (T) does not exceed min(r, c). Rather, we want to reduce the rank of f (A) by enhancing the linear coherence of the rows/columns of f (A). However, such a trivial mapping causes a problem in inverting from K to T by using the inverse function f ?1 . So we have to\n        1 As we will show, it is not necessary to specify what these two point sets are. However, without any knowledge about the light transport in the scene, it is difficult to determine the sample number in advance. As shown in Figure 4 , we focus on the light transport from point light sources on a 2D plane to image pixels captured from a fixed view point. In our setup, a column of the light transport matrix is directly obtained from the image of the scene under the a virtual point light source, while a row of the matrix is measured via a dual setup by exploiting the reciprocity of light transport [Hawkins et al. 2005; Sen et al. 2005]. To obtain a batch of rows and columns, we first capture the columns and then acquire the rows of the light transport matrix. We take images of the diffuser plane from the dual camera simultaneously to build the correspondence between the point light source positions and pixels of the dual camera image, in which the images captured by the dual camera are downsampled to 1024 ? 768 to match the projector?s resolution. The rank of a matrix is determined by the number of eigenvalues of the matrix that can preserve 95.0% energy of the original matrix. Here B i, j is the ground truth submatrix element that is not in the sparse sample set and B  ? i, j is the same submatrix element reconstructed using the kernel Nystr?m method. Figure 11 compares the rendering result of the reconstructed light transport matrix, the ground truth image captured from the object under the same lighting condition, and the result rendered by directly interpolating the nearby sample images.",
  "resources" : [ ]
}