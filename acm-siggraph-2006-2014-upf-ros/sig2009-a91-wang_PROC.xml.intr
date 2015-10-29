{
  "uri" : "sig2009-a91-wang_PROC.xml",
  "url" : "/Users/cbadenes/Documents/OEG/Projects/DrInventor/datasets/acm-siggraph-2006-2014-upf/sig2009/a91-wang_PROC.xml",
  "source" : {
    "name" : "SIGGRAPH",
    "uri" : "http://drinventor/SIGGRAPH",
    "url" : "http://drinventor/SIGGRAPH",
    "protocol" : "http"
  },
  "metainformation" : {
    "title" : "An Efficient GPU-based Approach for Interactive Global Illumination",
    "published" : "2009",
    "format" : "pdf",
    "language" : "en",
    "rights" : "GPLv2",
    "description" : "",
    "creators" : [ {
      "uri" : "http://drinventor/Rui Wang-null",
      "name" : "Rui Wang",
      "surname" : null
    }, {
      "uri" : "http://drinventor/Rui Wang-null",
      "name" : "Rui Wang",
      "surname" : null
    }, {
      "uri" : "http://drinventor/Kun-Zhou",
      "name" : "Kun",
      "surname" : "Zhou"
    }, {
      "uri" : "http://drinventor/Minghao-Pan",
      "name" : "Minghao",
      "surname" : "Pan"
    }, {
      "uri" : "http://drinventor/Hujun-Bao",
      "name" : "Hujun",
      "surname" : "Bao"
    } ]
  },
  "bagOfWords" : [ "interactive", "computation", "global", "illumination", "major", "challenge", "computer", "graphic", "research", "today", "effect", "multi-bounce", "indirect", "lighting", "caustic", "complex", "surface", "reflection", "important", "visual", "cue", "perception", "photorealism", "synthesize", "image", "however", "conventional", "cpu-based", "algorithm", "simulation", "cost", "effect", "often", "too", "high", "permit", "dynamic", "interaction", "where", "user", "can", "simultaneously", "change", "lighting", "viewpoint", "material", "geometry", "expect", "accurate", "real-time", "feedback", "change", "rapidly", "increase", "computation", "power", "modern", "gpus", "much", "attention", "have", "be", "direct", "exploit", "GPU", "achieve", "interactive", "global", "illumination", "exist", "method", "however", "typically", "focus", "very", "limited", "set", "illumination", "effect", "instance", "gpu-based", "ambient", "occlusion", "-lsb-", "Shanmugam", "Arikan", "bution", "point", "conform", "actual", "irradiance", "change", "next", "each", "cluster", "center", "we", "perform", "final", "gather", "sample", "its", "incident", "radiance", "field", "due", "indirect", "lighting", "step", "use", "fast", "gpu-based", "photon", "mapping", "algorithm", "-lsb-", "Zhou", "et", "al.", "2008", "-rsb-", "accelerate", "density", "estimation", "final", "gather", "we", "approximate", "entire", "photon", "tree", "compact", "illumination", "cut", "compute", "dynamically", "GPU", "we", "interpolate", "sample", "irradiance", "value", "each", "shade", "point", "produce", "final", "render", "result", "we", "method", "also", "handle", "one-bounce", "low-frequency", "glossy", "reflection", "approximate", "both", "sample", "radiance", "field", "brdf", "onto", "spherical", "harmonic", "-lrb-", "sh", "-rrb-", "basis", "set", "select", "irradiance", "sample", "point", "adaptively", "single", "pass", "we", "eliminate", "sequential", "computation", "require", "standard", "caching", "base", "method", "result", "we", "algorithm", "enable", "parallel", "computation", "implement", "entirely", "GPU", "achieve", "interactive", "frame", "rate", "variety", "complex", "global", "illumination", "effect", "Figure", "show", "example", "we", "gpu-based", "solution", "can", "easily", "adapt", "other", "many-core", "platform", "intel?s", "upcome", "Larrabee", "-lsb-", "Seiler", "et", "al.", "2008", "-rsb-", "today?s", "chip", "design", "quickly", "switch", "streaming", "massively", "parallel", "processor", "model", "we", "believe", "essential", "develop", "new", "algorithm", "exploit", "architecture", "achieve", "interactive", "global", "illumination", "cpu-based", "global", "illumination", "fundamental", "difficulty", "global", "illumination", "high", "computation", "cost", "incur", "indirect", "lighting", "where", "all", "surface", "contribute", "illumination", "scene", "instant", "radiosity", "-lsb-", "Keller", "1997", "-rsb-", "popular", "technique", "convert", "indirect", "illumination", "small", "set", "virtual", "point", "light", "-lrb-", "vpl", "-rrb-", "approach", "drastically", "reduce", "computation", "cost", "limit", "small", "number", "vpl", "only", "suitable", "primarily", "diffuse", "material", "photon", "mapping", "-lsb-", "Jensen", "2001", "-rsb-", "another", "popular", "solution", "involve", "photon", "scattering", "pass", "final", "gather", "pass", "accurately", "simulate", "indirect", "lighting", "complex", "scene", "large", "number", "photon", "need", "lead", "high", "computation", "cost", "-lsb-", "2002", "-rsb-", "Wald", "et", "al.", "implement", "interactive", "global", "illumination", "use", "cluster", "pc", "recently", "-lsb-", "Walter", "et", "al.", "2005", "-rsb-", "present", "LightCuts", "scalable", "method", "compute", "illumination", "from", "large", "number", "point", "light", "sublinear", "cost", "work", "aim", "high-quality", "rendering", "run", "offline", "caching", "interpolation", "since", "global", "illumination", "involve", "compute", "many", "ray", "common", "exploit", "coherence", "among", "ray", "reduce", "radiance", "sampling", "cost", "especially", "true", "indirect", "illumination", "which", "change", "smoothly", "make", "good", "candidate", "sparse", "sampling", "irradiance", "caching", "-lrb-", "ic", "-rrb-", "-lsb-", "Ward", "et", "al.", "1988", "-rsb-", "popular", "technique", "progressively", "cache", "diffuse", "irradiance", "sample", "octree", "reuse", "they", "along", "computation", "radiance", "caching", "-lsb-", "riv", "nek", "Gautron", "2005", "-rsb-", "extend", "ic", "record", "directional", "radiance", "use", "spherical", "harmonic", "-lsb-", "1999", "-rsb-", "Bala", "et", "al.", "present", "general", "approach", "exploit", "both", "spatial", "temporal", "coherence", "ray", "radiance", "interpolation", "recently", "-lsb-", "Arikan", "et", "al.", "2005", "-rsb-", "introduce", "fast", "approximation", "global", "illumination", "decompose", "radiance", "field", "farand", "near-field", "component", "which", "compute", "separately", "improve", "efficiency", "general", "cache", "scheme", "require", "sequentially", "insert", "spatial", "sample", "point", "datum", "structure", "which", "have", "frequently", "query", "update", "during", "computation", "make", "they", "unsuitable", "gpu?s", "data-parallel", "computation", "model", "Render", "Cache", "-lsb-", "Walter", "et", "al.", "1999", "-rsb-", "reuse", "radiance", "sample", "from", "previous", "frame", "reproject", "they", "current", "frame", "follow", "insertion", "small", "number", "new", "sample", "exploit", "temporal", "coherence", "render", "take", "long", "time", "converge", "shade", "cache", "-lsb-", "Tole", "et", "al.", "2002", "-rsb-", "perform", "caching", "interpolation", "object", "space", "lead", "faster", "convergence", "improve", "render", "quality", "however", "require", "scene", "geometry", "subdivide", "patch", "which", "unsuitable", "complex", "model", "furthermore", "lighting", "geometry", "change", "lead", "noticeable", "temporal", "artifact", "gpu-based", "global", "illumination", "rapidly", "increase", "computation", "power", "modern", "gpus", "much", "recent", "work", "have", "focus", "gpu-based", "solution", "global", "illumination", "-lsb-", "nijasure", "et", "al.", "2005", "-rsb-", "sample", "incident", "radiance", "GPU", "uniform", "3d", "grid", "point", "use", "low-resolution", "fix", "sample", "method", "do", "provide", "high", "accuracy", "reflective", "shadow", "map", "-lsb-", "dachsbacher", "Stamminger", "2005", "-rsb-", "treat", "shadow", "map", "pixel", "project", "from", "direct", "light", "source", "indirect", "source", "illuminate", "scene", "use", "image-space", "computation", "method", "enable", "fast", "one-bounce", "indirect", "lighting", "do", "handle", "multi-bounce", "interreflection", "similarly", "radiance", "cache", "splatting", "-lsb-", "Gautron", "et", "al.", "2005", "-rsb-", "use", "image-based", "final", "gathering", "approximate", "irradiance", "caching", "while", "fast", "method", "ignore", "occlusion", "final", "gather", "step", "which", "important", "produce", "indirect", "shadow", "Matrix", "row-column", "sampling", "-lsb-", "ha", "san", "et", "al.", "2007", "-rsb-", "convert", "illumination", "many", "point", "light", "exploit", "GPU", "shadow", "map", "cluster", "they", "representative", "light", "compute", "shadowed", "illumination", "from", "each", "method", "do", "yet", "perform", "interactive", "rate", "imperfect", "shadow", "map", "-lsb-", "Ritschel", "et", "al.", "2008", "-rsb-", "evaluate", "approximate", "shadow", "map", "many", "point", "light", "single", "pass", "GPU", "dramatically", "improve", "computation", "speed", "due", "lack", "ray", "trace", "framework", "method", "only", "suitable", "primarily", "diffuse", "surface", "can", "handle", "caustic", "perfectly", "specular", "material", "Photon", "mapping", "first", "implement", "GPU", "-lsb-", "Purcell", "et", "al.", "2003", "-rsb-", "use", "uniform", "grid", "structure", "store", "photon", "rendering", "take", "several", "seconds", "converge", "-lsb-", "hachisuka", "2005", "-rsb-", "introduce", "fast", "acceleration", "method", "final", "gather", "use", "GPU", "rasterization", "greatly", "improve", "offline", "render", "speed", "-lsb-", "Wyman", "Davis", "2006", "-rsb-", "propose", "image-space", "caustic", "algorithm", "capable", "simulate", "plausible", "caustic", "effect", "real-time", "method", "aim", "include", "other", "global", "illumination", "effect", "recently", "-lsb-", "Zhou", "et", "al.", "2008", "-rsb-", "introduce", "fast", "gpu-based", "kd-tree", "algorithm", "real-time", "ray", "trace", "caustic", "however", "incorporate", "general", "illumination", "effect", "remain", "unsolved", "framework", "we", "method", "build", "upon", "algorithm", "we", "extend", "work", "include", "complex", "illumination", "effect", "multi-bounce", "interreflection", "caustics-incurred", "indirect", "lighting" ],
  "content" : "Interactive computation of global illumination is a major challenge in computer graphics research today. Effects such as multi-bounce indirect lighting, caustics, and complex surface reflections are important visual cues for the perception of photorealism in synthesized images. However, with conventional CPU-based algorithms the simulation costs of such effects are often too high to permit dynamic interactions, where the user can simultaneously change the lighting, viewpoint, materials, and geometry, and expect accurate real-time feedbacks of such changes. With the rapidly increasing computation power of modern GPUs, much attention has been directed to exploiting the GPU to achieve interactive global illumination. Existing methods, however, typically focus on a very limited set of illumination effects. For instance, GPU-based ambient occlusion [Shanmugam and Arikan bution of these points conforms with the actual irradiance changes. Next, at each cluster center, we perform final gather to sample its incident radiance field due to indirect lighting. This step uses a fast GPU-based photon mapping algorithm [Zhou et al. 2008]. To accelerate the density estimation in final gather, we approximate the entire photon tree as a compact illumination cut that is computed dynamically on the GPU. We then interpolate the sampled irradiance values at each shading point to produce the final rendering result. Our method also handles one-bounce of low-frequency glossy reflections by approximating both the sampled radiance fields and BRDFs onto a spherical harmonics (SH) basis set. By selecting irradiance sample points adaptively in a single pass, we eliminate the sequential computation required by standard caching based methods. As a result, our algorithm enables parallel computation and is implemented entirely on the GPU, achieving interactive frame rates for a variety of complex global illumination effects. Figure 1 shows an example. Our GPU-based solution can be easily adapted to other many-core platforms such as Intel?s upcoming Larrabee [Seiler et al. 2008]. As today?s chip design is quickly switching to streaming and massively parallel processor models, we believe that it is essential to develop new algorithms that exploit such architecture to achieve interactive global illumination. CPU-based Global Illumination A fundamental difficulty in global illumination is the high computation cost incurred by indirect lighting, where all surfaces contribute illumination to the scene. Instant radiosity [Keller 1997] is a popular technique that converts indirect illumination to a small set of virtual point lights (VPLs). This approach drastically reduces the computation cost, but is limited to a small number of VPLs and is only suitable for primarily diffuse materials. Photon mapping [Jensen 2001] is another popular solution. It involves a photon scattering pass and a final gather pass to accurately simulate indirect lighting. For complex scenes, a large number of photons are needed, leading to high computation cost. In [2002], Wald et al. implemented interactive global illumination using a cluster of PCs. Recently, [Walter et al. 2005] presented LightCuts ? a scalable method that computes illumination from a large number of point lights at sublinear cost. Their work is aimed at high-quality rendering and runs offline. Caching and Interpolation Since global illumination involves computing many rays, it is common to exploit the coherence among rays to reduce radiance sampling cost. This is especially true for indirect illumination, which changes smoothly and makes a good candidate for sparse sampling. Irradiance caching (IC) [Ward et al. 1988] is a popular technique that progressively caches diffuse irradiance samples into an octree, and reuses them along the computation. Radiance caching [K riv? nek and Gautron 2005] extends IC by recording directional radiance using spherical harmonics. In [1999], Bala et al. presented a general approach to exploiting both spatial and temporal coherence of rays for radiance interpolation. Recently [Arikan et al. 2005] introduced a fast approximation to global illumination by decomposing radiance fields into farand near-field components, which are computed separately to improve efficiency. In general, these caching schemes require sequentially inserting spatial sample points into a data structure, which has to be frequently queried and updated during the computation. This makes them unsuitable for the GPU?s data-parallel computation model. The Render Cache [Walter et al. 1999] reuses radiance samples from previous frames by reprojecting them to the current frame, followed by the insertion of a small number of new samples. It  exploits temporal coherence but the rendering takes a long time to converge. The Shading Cache [Tole et al. 2002] performs caching and interpolation in object space, leading to faster convergence and improved rendering quality. However, it requires scene geometry to be subdivided into patches, which is unsuitable for complex models. Furthermore, lighting and geometry changes lead to noticeable temporal artifacts. GPU-based Global Illumination With the rapidly increasing computation power of modern GPUs, much recent work has focused on GPU-based solutions for global illumination. [Nijasure et al. 2005] sample incident radiance on the GPU at uniform 3D grid points. By using a low-resolution of fixed samples, this method does not provide high accuracy. Reflective shadow maps [Dachsbacher and Stamminger 2005] treat shadow map pixels projected from the direct light source as indirect sources illuminating the scene. Using image-space computation, this method enables fast one-bounce indirect lighting, but does not handle multi-bounce interreflections. Similarly, radiance cache splatting [Gautron et al. 2005] uses image-based final gathering to approximate irradiance caching. While fast, these methods ignore occlusions in the final gather step, which are important for producing indirect shadows. Matrix row-column sampling [Ha san et al. 2007] converts illumination to many point lights, then exploits GPU shadow mapping to cluster them into representative lights and compute shadowed illumination from each. This method does not yet perform at interactive rates. Imperfect shadow maps [Ritschel et al. 2008] evaluate approximate shadow maps for many point lights in a single pass on the GPU, dramatically improving the computation speed. Due to the lack of a ray tracing framework, these methods are only suitable for primarily diffuse surfaces, and cannot handle caustics or perfectly specular materials. Photon mapping was first implemented on the GPU in [Purcell et al. 2003] by using a uniform grid structure to store photons; their rendering takes several seconds to converge. [Hachisuka 2005] introduced a fast acceleration method for final gather by using GPU rasterization. This greatly improves offline rendering speed. [Wyman and Davis 2006] proposed an image-space caustics algorithm, capable of simulating plausible caustics effects in real-time. This method is not aimed to include other global illumination effects. Recently [Zhou et al. 2008] introduced a fast GPU-based kd-tree algorithm for real-time ray tracing and caustics. However, incorporating general illumination effects remains unsolved in their framework. Our method builds upon this algorithm, and we extend their work to include complex illumination effects such as multi-bounce interreflections and caustics-incurred indirect lighting.",
  "resources" : [ ]
}