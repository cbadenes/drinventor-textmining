{
  "uri" : "sig2009a-a128-matusik_PROC.xml",
  "url" : "/Users/cbadenes/Documents/OEG/Projects/DrInventor/datasets/acm-siggraph-2006-2014-upf/sig2009a/a128-matusik_PROC.xml",
  "source" : {
    "name" : "SIGGRAPH",
    "uri" : "http://drinventor/SIGGRAPH",
    "url" : "http://drinventor/SIGGRAPH",
    "protocol" : "http"
  },
  "metainformation" : {
    "title" : "Printing Spatially-Varying Reflectance",
    "published" : "2009",
    "format" : "pdf",
    "language" : "en",
    "rights" : "GPLv2",
    "description" : "",
    "creators" : [ {
      "uri" : "http://drinventor/Wojciech-Matusik",
      "name" : "Wojciech",
      "surname" : "Matusik"
    }, {
      "uri" : "http://drinventor/Boris-Ajdin",
      "name" : "Boris",
      "surname" : "Ajdin"
    }, {
      "uri" : "http://drinventor/Jinwei-Gu",
      "name" : "Jinwei",
      "surname" : "Gu"
    }, {
      "uri" : "http://drinventor/Jason-Lawrence",
      "name" : "Jason",
      "surname" : "Lawrence"
    }, {
      "uri" : "http://drinventor/Hendrik P. A.-Lensch",
      "name" : "Hendrik P. A.",
      "surname" : "Lensch"
    }, {
      "uri" : "http://drinventor/Fabio-Pellacini",
      "name" : "Fabio",
      "surname" : "Pellacini"
    }, {
      "uri" : "http://drinventor/Szymon-Rusinkiewicz",
      "name" : "Szymon",
      "surname" : "Rusinkiewicz"
    } ]
  },
  "bagOfWords" : [ "although", "real-world", "surface", "can", "exhibit", "significant", "variation", "material", "glossy", "diffuse", "metallic", "etc.", "printer", "usually", "use", "reproduce", "color", "gray-scale", "image", "we", "propose", "complete", "system", "use", "appropriate", "ink", "foil", "print", "document", "variety", "material", "property", "give", "set", "ink", "known", "bidirectional", "Reflectance", "distribution", "function", "-lrb-", "brdf", "-rrb-", "we", "system", "automatically", "find", "optimal", "linear", "combination", "approximate", "brdf", "target", "document", "Digital", "publishing", "have", "revolutionize", "way", "we", "create", "edit", "view", "document", "more", "importantly", "availability", "inexpensive", "yet", "high-quality", "home", "printer", "have", "greatly", "simplify", "process", "produce", "physical", "copy", "digital", "document", "drawback", "since", "appearance", "real-world", "surface", "can", "represent", "faithfully", "color", "gray", "value", "alone", "example", "real-world", "surface", "can", "exhibit", "different", "amount", "specularity", "range", "from", "perfectly", "matte", "-lrb-", "diffuse", "-rrb-", "glossy", "mirror-reflective", "can", "also", "appear", "metallic", "color", "specular", "highlight", "therefore", "exist", "large", "gap", "between", "way", "we", "represent", "digital", "document", "way", "physical", "equivalent", "look", "reality", "stand", "contrast", "steady", "progress", "range", "appearance", "property", "some", "printer", "can", "output", "example", "even", "now", "possible", "use", "matte", "glossy", "metallic", "ink", "apply", "highly", "specular", "overcoat", "print", "surface", "achieve", "large", "variety", "appearance", "order", "take", "full", "advantage", "capability", "however", "necessary", "use", "richer", "representation", "digital", "document", "also", "require", "redefine", "process", "convert", "representation", "physical", "copy", "we", "propose", "represent", "digital", "document", "use", "spatiallyvarying", "reflectance", "function", "instead", "gray-scale", "color", "value", "particular", "we", "use", "spatially-varying", "bidirectional", "Reflectance", "distribution", "function", "-lrb-", "svbrdf", "-rrb-", "which", "we", "write", "-lrb-", "-rrb-", "know", "svbrdf", "we", "can", "accurately", "predict", "how", "document", "appear", "from", "any", "desire", "viewpoint", "under", "any", "lighting", "configuration", "goal", "we", "publishing", "process", "can", "therefore", "state", "start", "reflectance", "-lrb-", "brdf", "-rrb-", "some", "set", "available", "ink", "reproduce", "goal", "svbrdf", "faithfully", "possible", "spatial", "pattern", "those", "ink", "thus", "we", "do", "restrict", "artist", "use", "individual", "ink", "spot", "color", "rather", "provide", "full", "spectrum", "material", "example", "figure", "show", "halftoned", "ramp", "between", "two", "ink", "different", "specularity", "orient", "reflect", "checkerboard", "target", "can", "see", "effect", "dither", "give", "impression", "new", "brdf", "linear", "combination", "ink", "direct", "consequence", "linearity", "light", "transport", "moreover", "allow", "user", "think", "term", "material", "instead", "individual", "ink", "we", "gain", "two", "benefit", "first", "we", "can", "leverage", "fact", "combination", "ink", "may", "automatically", "employ", "broaden", "range", "available", "appearance", "although", "we", "could", "simply", "map", "each", "target", "brdf", "closest", "printable", "brdf", "-lrb-", "discuss", "section", "3.2", "-rrb-", "would", "lead", "undesirable", "clamp", "artifact", "target", "brdf", "fall", "outside", "gamut", "available", "ink", "instead", "we", "draw", "inspiration", "from", "gamut-mapping", "process", "perform", "all", "-lrb-", "color", "-rrb-", "printer", "-lrb-", "section", "4.1", "-rrb-", "all", "other", "point", "represent", "corresponding", "linear", "combination", "remap", "brdf", "final", "pattern", "can", "preview", "-lrb-", "under", "arbitrary", "view", "lighting", "-rrb-", "send", "printer", "contrast", "we", "goal", "print", "image", "can", "continuously", "change", "appearance", "different", "view", "accord", "desire", "material", "property", "Digital", "halfton", "method", "do", "have", "restriction", "physical", "screen", "variety", "algorithm", "have", "be", "develop", "detailed", "survey", "can", "find", "-lsb-", "ulichney", "1987", "Kang", "1999", "-rsb-", "Material", "Perception", "understand", "perception", "material", "property", "human", "visual", "system", "essential", "evaluate", "visual", "difference", "between", "desire", "print", "surface", "thus", "important", "component", "we", "printing", "pipeline", "however", "still", "area", "active", "research", "Fleming", "et", "al.", "-lsb-", "2001", "-rsb-", "show", "human", "can", "recognize", "reflectance", "under", "natural", "illumination", "high", "accuracy", "from", "single", "image", "despite", "flexibility", "svbrdf", "have", "drawback", "require", "significant", "storage", "when", "represent", "uncompressed", "generate", "factored", "svbrdf", "from", "measure", "datum", "we", "constrain", "weight", "map", "each", "pixel", "form", "non-negative", "partition", "unity", "-lrb-", "i.e.", "each", "weight", "must", "between", "sum", "must", "-rrb-", "although", "typically", "many", "factorization", "satisfy", "constraint", "we", "especially", "interested", "those", "have", "basis", "brdf", "lie", "near", "convex", "hull", "brdf", "document", "important", "we", "gamut-mapping", "approach", "-lrb-", "section", "4.1", "-rrb-", "other", "instance", "we", "adopt", "modify", "k-means", "clustering", "which", "follow", "each", "kmean", "iteration", "we", "remove", "from", "consideration", "those", "point", "well-represented", "linear", "combination", "cluster", "center", "result", "show", "paper", "season?s", "greeting", "dove", "dataset", "be", "produce", "use", "SACLS", "while", "Oak", "Leaf", "Rusty", "Flange", "dataset", "use", "convex", "k-means", "algorithm", "moreover", "we", "recognize", "specular-highlight", "shape", "most", "salient", "feature", "different", "ink", "available", "we", "so", "we", "seek", "representation", "can", "accurately", "describe", "color", "shape", "highlight", "while", "sacrifice", "representability", "phenomenon", "retroreflection", "grazing-angle", "effect", "we", "choose", "represent", "each", "brdf", "-lrb-", "-rrb-", "sample", "curve", "value", "along", "halfway", "angle", "which", "define", "angle", "between", "surface", "normal", "bisector", "view", "light", "direction", "-lsb-", "Rusinkiewicz", "1998", "-rsb-", "nevertheless", "give", "we", "target", "application", "we", "choose", "employ", "directional-light", "metric", "which", "permit", "significant", "simplification", "case", "curve", "-lrb-", "see", "appendix", "-rrb-", "show", "Figure", "once", "we", "have", "target", "svbrdf", "-lrb-", "either", "measure", "specify", "user", "-rrb-", "we", "must", "project", "onto", "space", "span", "printer", "brdf", "dataset", "each", "pixel", "we", "directly", "optimize", "linear", "blending", "weight", "reproduce", "target", "brdf", "subject", "where", "-lrb-", "-rrb-", "target", "brdf", "-lrb-", "-rrb-", "printer", "brdf", "blend", "weight", "we", "must", "compute", "distance", "function", "-lrb-", "discuss", "above", "-rrb-", "however", "when", "we", "must", "approximate", "target", "brdf", "we", "wish", "use", "objective", "function", "minimize", "perceptual", "difference", "between", "target", "approximation", "gamut", "mapping", "color", "goal", "compress", "range", "while", "preserve", "perceptual", "similarity", "remap", "brdf", "two", "pixel", "target", "have", "similar", "material", "should", "continue", "have", "similar", "material", "when", "re-mapped", "while", "relative", "difference", "between", "material", "should", "preserve", "example", "suppose", "we", "have", "four", "brdf", "we", "want", "print", "relative", "glossiness", "100", "80", "50", "10", "show", "Figure", "alternative", "would", "have", "be", "employ", "soft", "clamp", "target", "brdf", "near", "outside", "convex", "hull", "printer", "brdf", "strategy", "inspire", "color-mapping", "approach", "preserve", "hue", "value", "while", "gradually", "clamp", "saturation", "therefore", "goal", "halfton", "algorithm", "pick", "exactly", "one", "printer", "brdf", "place", "each", "pixel", "otherwise", "we", "observe", "significant", "artifact", "either", "foil", "do", "stick", "paper", "too", "much", "foil", "deposit", "each", "channel", "we", "store", "accumulate", "intensity", "from", "continuous", "map", "minus", "number", "pixel", "channel", "have", "be", "emit", "note", "final", "stage", "map", "can", "overlap", "necessary", "create", "desire", "brdf", "some", "pixel", "we", "thus", "obtain", "entire", "curve", "single", "camera", "light", "source", "position", "order", "acquire", "entire", "dynamic", "range", "reflectance", "sample", "-lrb-", "range", "specularity", "peak", "go", "from", "around", "225", "silver", "foil", "around", "0.85", "black", "ink", "-rrb-", "first", "we", "would", "like", "take", "account", "scattering", "property", "substrate" ],
  "content" : "Although real-world surfaces can exhibit significant variation in materials ? glossy, diffuse, metallic, etc. ? printers are usually used to reproduce color or gray-scale images. We propose a complete system that uses appropriate inks and foils to print documents with a variety of material properties. Given a set of inks with known Bidirectional Reflectance Distribution Functions (BRDFs), our system automatically finds the optimal linear combinations to approximate the BRDFs of the target documents. Digital publishing has revolutionized the way we create, edit, and view documents. More importantly, the availability of inexpensive yet high-quality home printers has greatly simplified the process of producing physical copies of digital documents. This is a drawback since the appearance of real-world surfaces cannot be represented faithfully by color or gray values alone. For example, real-world surfaces can exhibit different amounts of specularity: they range from perfectly matte (diffuse) to glossy to mirror-reflective. They can also appear metallic, with colored specular highlights. Therefore, there exists a large gap between the way we represent digital documents and the way their physical equivalents look in reality. This stands in contrast to the steady progress in the range of appearance properties that some printers can output. For example, even now it is possible to use matte, glossy, or metallic inks and apply highly specular overcoats to printed surfaces, to achieve a large variety of appearances. In order to take full advantage of these capabilities, however, it is necessary to use a richer representation for digital documents. It is also required to redefine the process of converting this representation to a physical copy. We propose to represent a digital document using a spatiallyvarying reflectance function instead of gray-scale or color values. In particular, we use a spatially-varying Bidirectional Reflectance Distribution Function (svBRDF), which we will write as f r (x, ? i , ? o ). Knowing the svBRDF, we can accurately predict how the document will appear, from any desired viewpoint and under any lighting configuration. The goal of our publishing process can therefore be stated as starting with the reflectances (BRDFs) of some set of available inks, and reproducing the goal svBRDF as faithfully as possible with a spatial pattern of those inks. Thus, we do not restrict the artist to using individual inks as ?spot colors,? but rather provide a full spectrum of materials. For example, Figure 2 shows a halftoned ramp between two inks of different specularities, oriented to reflect a checkerboard target. As can be seen, the effect of dithering is to give the impression of new BRDFs that are linear combinations of the inks ? this is a direct consequence of the linearity of light transport. Moreover, by allowing the user to think in terms of materials instead of individual inks, we gain two benefits. First, we can leverage the fact that combinations of inks may be automatically employed to broaden the range of available appearance. Although we could simply map each target BRDF to the closest printable BRDF (as discussed in Section 3.2), this would lead to undesirable clamping artifacts if target BRDFs fall outside the gamut of the available inks. Instead, we draw inspiration from the gamut-mapping process performed by all (color) printers (Section 4.1). All other points are represented as the corresponding linear combinations of the remapped BRDFs. The final patterns can be previewed (under arbitrary view and lighting), and then are sent to the printer. In contrast, our goal is to print images that can continuously change appearance for different views, according to the desired material properties. Digital halftoning methods do not have the restrictions of physical screens, and a variety of algorithms have been developed; detailed surveys can be found in [Ulichney 1987; Kang 1999]. Material Perception: Understanding the perception of material properties by the human visual system is essential for evaluating the visual differences between the desired and printed surface, and is thus an important component of our printing pipeline. However, this is still an area of active research. Fleming et al. [2001] showed that humans can recognize reflectance under natural illumination with high accuracy from a single image. Despite their flexibility, svBRDFs have the drawback of requiring significant storage, when represented uncompressed. In generating a factored svBRDF from measured data, we constrain the weight maps at each pixel to form a non-negative partition of unity (i.e., each weight must be between 0 and 1, and their sum must be 1). Although there are typically many factorizations satisfying this constraint, we are especially interested in those having basis BRDFs that lie on or near the convex hull of the BRDFs in the document: this is important for our gamut-mapping approach (Section 4.1). In other instances, we adopt a modified k-means clustering in which, following each kmeans iteration, we remove from consideration those points that are well-represented as linear combinations of the cluster centers. Of the results shown in this paper, the ?Season?s Greetings? and ?Dove? datasets were produced using SACLS, while the ?Oak Leaf? and ?Rusty Flange? datasets used the convex k-means algorithm. Moreover, we recognize that specular-highlight shape is the most salient feature of the different inks available to us, and so we seek a representation that can accurately describe the color and shape of highlights, while sacrificing the representability of phenomena such as retroreflection and grazing-angle effects. We choose to represent each BRDF as f r = f ( ? h ): a sampled curve of values along the halfway angle ? h , which is defined as the angle between the surface normal and the bisector of the view and light directions [Rusinkiewicz 1998]. Nevertheless, given our target application, we choose to employ the directional-light metric, which permits a significant simplification in the case of ? h curves (see Appendix). As shown in Figure 3 , once we have a target svBRDF (either measured or specified by the user) we must project it onto the space spanned by the printer BRDFs. For these datasets, at each pixel we directly optimize for linear blending weights that reproduce the target BRDFs: subject to K 0 ? ? k ? 1 and ? ? k = 1, k=1 where f ( ? i , ? o ) is the target BRDF, f k ( ? i , ? o ) are the printer BRDFs, ? k are the blending weights we must compute, and d is a distance function (discussed above). However, when we must approximate the target BRDF, we wish to use an objective function that minimizes the perceptual difference between the target and the approximation. As with gamut mapping of colors, the goal is to compress the range while preserving the perceptual similarity of remapped BRDFs: two pixels in the target that have similar materials should continue to have similar materials when re-mapped, while relative differences between materials should be preserved. For example, suppose we have four BRDFs we want to print, with relative glossiness of 100%, 80%, 50%, and 10%, as shown in Figure 5 . An alternative would have been to employ a ?soft clamp? for target BRDFs near or outside the convex hull of printer BRDFs: a strategy inspired by color-mapping approaches that preserve hue and value, while gradually clamping saturation. Therefore, the goal of the halftoning algorithm is to pick exactly one printer BRDF to be placed at each pixel. Otherwise, we observe significant artifacts: either the foil does not stick to the paper, or too much foil is deposited. That is, for each channel we store the accumulated intensity from the continuous maps minus the number of pixels of that channel that have been emitted. Note that at this final stage the maps can overlap, if this is necessary to create the desired BRDF at some pixel. We thus obtain an entire ? h curve with a single camera and light source position. , in order to acquire the entire dynamic range of the reflectance of the sample (the range of specularity peaks goes from around 225 for silver foil to around 0.85 for black ink). First, we would like to take into account the scattering properties of the substrate.",
  "resources" : [ ]
}