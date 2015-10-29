{
  "uri" : "sig2012a-a131-kopf_PROC.xml",
  "url" : "/Users/cbadenes/Documents/OEG/Projects/DrInventor/datasets/acm-siggraph-2006-2014-upf/sig2012a/a131-kopf_PROC.xml",
  "source" : {
    "name" : "SIGGRAPH",
    "uri" : "http://drinventor/SIGGRAPH",
    "url" : "http://drinventor/SIGGRAPH",
    "protocol" : "http"
  },
  "metainformation" : {
    "title" : "Quality Prediction for Image Completion",
    "published" : "2012",
    "format" : "pdf",
    "language" : "en",
    "rights" : "GPLv2",
    "description" : "",
    "creators" : [ {
      "uri" : "http://drinventor/Johannes-Kopf",
      "name" : "Johannes",
      "surname" : "Kopf"
    }, {
      "uri" : "http://drinventor/Wolf-Kienzle",
      "name" : "Wolf",
      "surname" : "Kienzle"
    }, {
      "uri" : "http://drinventor/Steven M.-Drucker",
      "name" : "Steven M.",
      "surname" : "Drucker"
    }, {
      "uri" : "http://drinventor/Sing Bing-Kang",
      "name" : "Sing Bing",
      "surname" : "Kang"
    } ]
  },
  "bagOfWords" : [ "image", "completion", "inpainting", "popular", "image", "editing", "tool", "object", "removal", "replacement", "digital", "photograph", "restoration", "variety", "completion", "algorithm", "have", "be", "develop", "scientific", "community", "over", "past", "decade", "image", "completion", "now", "feature", "commercial", "photo", "editing", "software", "Adobe", "Photoshop", "most", "previous", "work", "image", "completion", "use", "fill", "hole", "after", "unwanted", "object", "remove", "same", "algorithm", "however", "can", "also", "use", "extend", "image", "beyond", "its", "original", "boundary", "useful", "fill", "beyond", "irregular", "boundary", "stitch", "panorama?this", "application", "focus", "paper", "casually", "shoot", "panorama", "often", "have", "irregular", "boundary", "-lrb-", "e.g.", "Figure", "-rrb-", "most", "user", "however", "prefer", "output", "image", "rectangular", "boundary", "trivial", "solution", "implement", "most", "stitching", "software", "crop", "largest", "box", "fully", "contain", "within", "panorama", "simple", "method", "often", "remove", "large", "part", "input", "alternative", "apply", "any", "exist", "completion", "algorithm", "fill", "miss", "region", "panorama", "bound", "box", "unfortunately", "all", "exist", "image", "completion", "algorithm", "fail", "occasion", "failure", "typically", "show", "up", "either", "inability", "synthesize", "some", "texture", "well", "result", "semantically", "implausible", "-lrb-", "see", "Figure", "-rrb-", "addition", "difficult", "anticipate", "when", "where", "algorithm", "fail", "give", "arbitrary", "input", "image", "paper", "we", "use", "machine", "learn", "predict", "quality", "image", "completion", "support", "prediction", "we", "design", "we", "image", "completion", "algorithm", "produce", "high", "quality", "result", "allow", "association", "between", "complete", "pixel", "know", "pixel", "create", "we", "build", "exist", "non-parametric", "optimization", "framework", "Wexler", "et", "al.", "-lsb-", "2007", "-rsb-", "-lrb-", "which", "also", "implement", "Content", "Aware", "fill", "feature", "Adobe", "Photoshop", "-rrb-", "previous", "work", "show", "algorithm", "perform", "best", "source", "location", "patch", "constrain", "certain", "area", "e.g.", "see", "-lsb-", "Barnes", "et", "al.", "2009", "-rsb-", "we", "use", "heuristic", "automatically", "derive", "search", "space", "see", "http://www.adobe.com/technology/projects/content-aware-fill.html", "constraint", "base", "overlap", "texture", "segmentation", "constraint", "allow", "we", "design", "simple", "method", "predict", "algorithm", "performance", "base", "prediction", "we", "compute", "crop", "shape", "before", "completion", "actually", "carry", "out", "avoid", "unnecessarily", "complete", "crop", "pixel", "validate", "train", "we", "prediction", "function", "we", "run", "mechanical", "Turk", "user", "study", "obtain", "about", "9,500", "good", "bad", "label", "crop", "from", "complete", "image", "from", "large", "number", "subject", "label", "use", "estimate", "we", "prediction", "function", "via", "crossvalidation", "we", "test", "we", "algorithm", "extensive", "collection", "input", "image", "another", "user", "study", "compare", "we", "result", "those", "various", "state-of-the-art", "completion", "algorithm", "yet", "another", "user", "study", "we", "evaluate", "performance", "we", "automatic", "crop", "optimization", "addition", "example", "include", "paper", "all", "we", "result", "comparison", "include", "supplementary", "material", "while", "substantial", "amount", "previous", "work", "image", "completion", "-lrb-", "also", "refer", "inpainting", "image", "filling", "-rrb-", "best", "we", "knowledge", "we", "aware", "any", "method", "can", "predict", "quality", "before", "completion", "be", "able", "predict", "quality", "would", "allow", "system", "determine", "input", "image", "can", "properly", "restore", "edit", "we", "case", "estimate", "desire", "crop", "panorama", "result", "system", "complete", "only", "what", "need", "note", "exist", "crop", "technique", "-lsb-", "Zhang", "et", "al.", "2005", "-rsb-", "use", "only", "available", "image", "datum", "crop", "texture", "quality", "assessment", "technique", "closest", "approach", "ours", "objective", "function", "Kwatra", "et", "al.", "-lsb-", "2005", "-rsb-", "measure", "similarity", "local", "patch", "target", "texture", "measure", "poor", "predictor", "quality", "-lrb-", "show", "section", "-rrb-", "Swarmy", "et", "al.", "-lsb-", "2011", "-rsb-", "show", "linear", "combination", "image", "parameter", "-lrb-", "intensity", "mean", "variance", "entropy", "band", "information", "-rrb-", "can", "use", "assess", "texture", "quality", "both", "case", "however", "texture", "have", "generate", "first", "we", "now", "briefly", "survey", "representative", "method", "image", "completion", "which", "we", "classify", "primarily", "example-based", "diffusionbased", "Komodakis", "Tziritas", "-lsb-", "2007", "-rsb-", "provide", "excellent", "review", "inpaint", "technique", "diffusion-based", "technique", "often", "refer", "inpainting", "typically", "work", "well", "small", "narrow", "hole", "e.g.", "remove", "scratch", "from", "scan", "old", "photograph", "less", "appropriate", "complete", "stitch", "panorama", "large", "open-ended", "miss", "region", "due", "inability", "synthesize", "texture", "one", "good", "representative", "diffusion-based", "technique", "Bertalmio", "et", "al.", "-lsb-", "2000", "-rsb-", "prolong", "isophote", "line", "miss", "area", "example-based", "technique", "tend", "more", "effective", "fill", "larger", "hole", "than", "diffusion-based", "technique", "Efros", "Leung", "-lsb-", "1999", "-rsb-", "popularize", "use", "non-parametric", "sampling", "texture", "synthesis", "-lrb-", "extension", "image", "completion", "-rrb-", "many", "example-based", "technique", "base", "core", "concept", "Representative", "technique", "include", "block-based", "matching", "structurebased", "priority", "-lsb-", "Criminisi", "et", "al.", "2003", "-rsb-", "use", "hierarchical", "filter", "initialization", "adaptive", "region", "instead", "patch", "-lsb-", "Drori", "et", "al.", "2003", "-rsb-", "optimization", "texture", "energy", "function", "-lsb-", "Wexler", "et", "al.", "2007", "Kwatra", "et", "al.", "2005", "Darabi", "et", "al.", "2012", "-rsb-", "application", "user", "specification", "structure", "-lsb-", "Sun", "et", "al.", "2005", "-rsb-", "mrf", "exemplar", "sample", "label", "-lsb-", "Komodakis", "Tziritas", "2007", "-rsb-", "search", "globally-transformed", "patch", "-lsb-", "Mansfield", "et", "al.", "2011", "-rsb-", "Kawai", "et", "al.", "-lsb-", "2008", "-rsb-", "adapt", "work", "Wexler", "et", "al.", "-lsb-", "2007", "-rsb-", "use", "ssd-based", "objective", "function", "handle", "regular", "-lrb-", "fine-grained", "-rrb-", "texture", "addition", "compensate", "local", "brightness", "change", "linearly", "fitting", "intensity", "match", "patch", "Pritch", "et", "al.", "-lsb-", "2009", "-rsb-", "cast", "problem", "image", "synthesis", "find", "optimal", "shift-map", "pixel", "base", "global", "factor", "-lrb-", "image", "size", "object", "arrangement", "-rrb-", "local", "feature", "-lrb-", "saliency", "map", "-rrb-", "well", "spatial", "regularization", "have", "demonstrate", "technique", "image", "retargeting", "rearrangement", "completion", "many", "previous", "method", "rely", "quickly", "find", "similar", "image", "patch", "recent", "PatchMatch", "algorithm", "-lsb-", "Barnes", "et", "al.", "2009", "-rsb-", "greatly", "improve", "speed", "replace", "previously", "employ", "tree-based", "search", "technique", "much", "faster", "randomize", "algorithm", "practically", "all", "automatic", "technique", "rely", "exemplar", "-lrb-", "exception", "-lsb-", "Matsushita", "et", "al.", "2006", "-rsb-", "-rrb-", "do", "restrict", "search", "result", "technique", "prone", "same", "problem", "those", "-lsb-", "Wexler", "et", "al.", "2007", "-rsb-", "where", "perceptually", "implausible", "patch", "could", "use", "image", "completion", "addition", "be", "design", "performance", "prediction", "mind", "difficult", "anticipate", "degree", "success", "failure", "within", "miss", "region" ],
  "content" : "Image completion or inpainting is a popular image editing tool for object removal and replacement or digital photograph restoration. A variety of completion algorithms have been developed in the scientific community over the past decade, and image completion is now a feature in commercial photo editing software such as Adobe Photoshop. In most previous work, image completion is used to fill holes after unwanted objects are removed. The same algorithms, however, can also be used to extend an image beyond its original boundaries. This is useful for filling beyond the irregular boundaries of a stitched panorama?this application is the focus of this paper. Casually shot panoramas often have irregular boundaries (e.g., Figure 1). Most users, however, prefer output images with rectangular boundaries. The trivial solution implemented by most stitching software is to crop to the largest box that is fully contained within the panorama. This simple method often removes large parts of the input. The alternative is to apply any existing completion algorithm to fill the missing regions of the panorama bounding box. Unfortunately, all existing image completion algorithms fail on occasion; the failure typically shows up as either inability to synthesize some textures well or results that are semantically implausible (see Figure 2 ). In addition, it is difficult to anticipate when and where such algorithms will fail given an arbitrary input image. In this paper, we use machine learning to predict the quality of image completion. To support this prediction, we design our image completion algorithm to produce high quality results and to allow associations between completed pixels and known pixels to be created. We build on the existing non-parametric optimization framework of Wexler et al. [2007] (which is also implemented in the Content Aware Fill feature of Adobe Photoshop 1 ). Previous work showed that this algorithm performs best if the source locations for patches are constrained to certain areas, e.g., see [Barnes et al. 2009]. We use a heuristic that automatically derives search space 1 see http://www.adobe.com/technology/projects/content-aware-fill.html constraints based on overlapping texture segmentation. These constraints allow us to design a simple method to predict algorithm performance. Based on the prediction we compute a crop shape before the completion is actually carried out, avoiding unnecessarily completing cropped pixels. To validate and train our prediction function, we ran a Mechanical Turk user study to obtain about 9,500 ?good? / ?bad? labels on crops from completed images from a large number of subjects. These labels are used to estimate our prediction function via crossvalidation. We tested our algorithm on an extensive collection of input images, and in another user study, compared our results with those of various state-of-the-art completion algorithms. In yet another user study, we evaluated the performance of our automatic crop optimization. In addition to the examples included in this paper, all of our results and comparisons are included in the supplementary material. While there is a substantial amount of previous work on image completion (also referred to as inpainting or image filling), to the best of our knowledge, we are not aware of any methods that can predict quality before completion. Being able to predict quality would allow the system to determine if the input image can be properly restored or edited, or in our case, estimate the desired crop of a panorama. As a result, the system completes only what is needed. Note that existing cropping techniques such as that of [Zhang et al. 2005] use only available image data for cropping. Texture quality assessment techniques are the closest approaches to ours. The objective function of Kwatra et al. [2005] measures similarity of local patches to the target texture, but this measure is a poor predictor of quality (as shown in Section 5). Swarmy et al. [2011] show that a linear combination of image parameters (such as intensity mean, variance, entropy, and band information) can be used to assess texture quality. In both cases, however, the texture has to be generated first. We now briefly survey representative methods for image completion, which we classify as primarily example-based or diffusionbased. Komodakis and Tziritas [2007] provided an excellent review of inpainting techniques. Diffusion-based techniques , often referred to as ?inpainting,? typically work well for small or narrow holes, e.g., for removing scratches from a scanned old photograph. They are less appropriate for completing stitched panoramas with large open-ended missing regions due to their inability to synthesize textures. One good representative of diffusion-based techniques is that of Bertalmio et al. [2000]; it prolongs isophote lines in the missing areas. Example-based techniques tend to be more effective for filling larger holes than diffusion-based techniques. Efros and Leung [1999] popularized the use of non-parametric sampling for texture synthesis (and by extension, image completion). Many example-based techniques are based on this core concept. Representative techniques include block-based matching with structurebased priority [Criminisi et al. 2003], use of hierarchical filtering as initialization and adaptive regions instead of patches [Drori et al. 2003], optimization of a texture energy function [Wexler et al. 2007; Kwatra et al. 2005; Darabi et al. 2012], application of user specification of structure [Sun et al. 2005], MRF with exemplars as sample labels [Komodakis and Tziritas 2007], and search for globally-transformed patches [Mansfield et al. 2011]. Kawai et al. [2008] adapted the work of Wexler et al. [2007] using an SSD-based objective function to handle regular (fine-grained)  textures. In addition, they compensate for local brightness changes by linearly fitting the intensity of the matched patch. Pritch et al. [2009] cast the problem of image synthesis as finding an optimal shift-map of pixels based on global factors (such as image size and object arrangement) and local features (such as saliency map) as well as spatial regularization. They have demonstrated their technique on image retargeting, rearrangement, and completion. Many of the previous methods rely on quickly finding similar image patches. The recent PatchMatch algorithm [Barnes et al. 2009] greatly improves their speed by replacing the previously employed tree-based search techniques with a much faster randomized algorithm. Practically all the automatic techniques that rely on exemplars (with the exception of [Matsushita et al. 2006]) do not restrict their search. As a result, such techniques are prone to the same problems as those of [Wexler et al. 2007], where perceptually implausible patches could be used for image completion. In addition, they were not designed with performance prediction in mind. It is difficult to anticipate the degree of success or failure within the missing regions.",
  "resources" : [ ]
}